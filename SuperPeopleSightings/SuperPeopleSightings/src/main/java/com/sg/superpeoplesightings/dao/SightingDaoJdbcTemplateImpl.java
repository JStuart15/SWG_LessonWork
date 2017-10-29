/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.dao.LocationDaoJdbcTemplateImpl.LocationMapper;
import com.sg.superpeoplesightings.dao.SuperPersonDaoJdbcTemplateImpl.SuperPersonMapper;
import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jstuart15
 */
public class SightingDaoJdbcTemplateImpl implements SightingDao {

    private SuperPersonDao superPersonDao;

    @Inject
    public SightingDaoJdbcTemplateImpl(SuperPersonDao superPersonDao) {
        this.superPersonDao = superPersonDao;
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_INSERT_SIGHTING
            = "insert into sightings "
            + "(location_id, `date`) "
            + "values(?, ?)";

    private static final String SQL_INSERT_SUPER_PEOPLE_SIGHTINGS
            = "insert into super_people_sightings (super_person_id, sighting_id) "
            + "values (?, ?)";

    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where sighting_id = ?";

    private static final String SQL_DELETE_SUPER_PEOPLE_SIGHTINGS
            = "delete from super_people_sightings where sighting_id = ?";

    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "select * from sightings";

    private static final String SQL_SELECT_SIGHTING
            = "select * from sightings where sighting_id = ?";

    private static final String SQL_UPDATE_SIGHTING
            = "update sightings set location_id = ?, date = ? "
            + "where sighting_id = ?";

    private static final String SQL_SELECT_SUPER_PEOPLE_BY_SIGHTING_ID
            = "select sp.* from super_people sp "
            + "inner join super_people_sightings sps on sps.super_person_id = "
            + "sp.super_person_id where sps.sighting_id = ?";

    private static final String SQL_SELECT_LOCATION_BY_SIGHTING_ID
            = "select l.* from locations l "
            + "inner join sightings s on l.location_id = s.location_id "
            + "where s.sighting_id = ?";

    private static final String SQL_SELECT_LAST10_SIGHTINGS
            = "select * from sightings s order by s.date desc limit 10";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sighting) {
        //first insert into sighting table and get new sighting id
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getDate().toString());
        sighting.setSightingId(jdbcTemplate
                .queryForObject("select LAST_INSERT_ID()", Integer.class));

        //now update the super_people_sightings table
        insertSuperPeopleSightings(sighting);
        return sighting;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SIGHTINGS, sightingId);
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSighting(Sighting sighting) {
        //update sighting table
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getDate().toString(),
                sighting.getSightingId());
        //java.sql.Date.valueOf(LocalDate);
        //delete super_people_sightings relationships and then reset them
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SIGHTINGS,
                sighting.getSightingId());
        insertSuperPeopleSightings(sighting);
    }

    @Override
    public Sighting getSightingById(int id) {
        try {
            //get details from the sightings table
            Sighting sighting = jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING,
                    new SightingMapper(),
                    id);
            //get the superPeople for this sighting and set the list
            sighting.setSuperPeople(findSuperPeopleForSighting(sighting));
            //get the location object for the sighting
            sighting.setLocation(findLocationForSighting(sighting));
            //super people should have powers and orgs

            return sighting;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        List<Sighting> sightings = new ArrayList<>();
        sightings = jdbcTemplate
                .query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
        for (Sighting sighting : sightings) {
            sighting.setSuperPeople(findSuperPeopleForSighting(sighting));
            sighting.setLocation(findLocationForSighting(sighting));
        }
        return sightings;
    }

    @Override
    public List<Sighting> getLast10Sightings() {
        List<Sighting> sightings = new ArrayList<>();
        sightings = jdbcTemplate
                .query(SQL_SELECT_LAST10_SIGHTINGS, new SightingMapper());
        for (Sighting sighting : sightings) {
            sighting.setSuperPeople(findSuperPeopleForSighting(sighting));
            sighting.setLocation(findLocationForSighting(sighting));
        }
        return sightings;
    }

    // HELPER METHODS
    // ==============
    private void insertSuperPeopleSightings(Sighting sighting) {
        final int sightingId = sighting.getSightingId();
        final List<SuperPerson> superPeople = sighting.getSuperPeople();
        for (SuperPerson superPerson : superPeople) {
            jdbcTemplate.update(SQL_INSERT_SUPER_PEOPLE_SIGHTINGS,
                    superPerson.getSuperPersonId(),
                    sightingId);
        }
    }

    private List<SuperPerson> findSuperPeopleForSighting(Sighting sighting) {
        List<SuperPerson> superPeople = jdbcTemplate
                .query(SQL_SELECT_SUPER_PEOPLE_BY_SIGHTING_ID,
                        new SuperPersonMapper(), sighting.getSightingId());

        //@todo - refactor this
        List<Integer> superPeopleIds = new ArrayList<>();
        superPeople.forEach((superPerson) -> {
            superPeopleIds.add(superPerson.getSuperPersonId());
        });

        superPeople.clear();//empty the list, we will rebuild it

        for (Integer superPersonId : superPeopleIds) {
            superPeople.add(superPersonDao.getSuperPersonById(superPersonId));
        }
        return superPeople;
    }

    private Location findLocationForSighting(Sighting s) {
        return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION_BY_SIGHTING_ID,
                new LocationMapper(),
                s.getSightingId());
    }

    //MAPPER
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sighting_id"));
            s.setDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
            return s;
        }
    }
}
