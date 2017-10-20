/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_INSERT_SIGHTING
            = "insert into sightings "
            + "(location_id, date) "
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
        //first insert into sighting table and get new sighting id
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getLocationId(),
                sighting.getDate());
        sighting.setLocationId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));

        //now update the super_people_sightings table
        insertSuperPeopleSightings(sighting);
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
                sighting.getLocationId(),
                sighting.getDate(),
                sighting.getSightingId());
        //delete super_people_sightings relationships and then rest them
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
            return sighting;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    // @todo - high - move this to the SuperPerson Impl and make it public
    private static final class SuperPersonMapper implements RowMapper<SuperPerson> {

        @Override
        public SuperPerson mapRow(ResultSet rs, int i) throws SQLException {
            SuperPerson sp = new SuperPerson();
            sp.setSuperPersonId(rs.getInt("super_person_id"));
            sp.setSuperPowerId(rs.getInt("super_power_id"));
            sp.setName(rs.getString("name"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }

    // HELPER METHODS
    // ==============
    private void insertSuperPeopleSightings(Sighting sighting) {
        final int sightingId = sighting.getSightingId();
        final List<SuperPerson> superPeople = sighting.getSuperPeople();
        for (SuperPerson superPerson : superPeople) {
            jdbcTemplate.update(SQL_INSERT_SUPER_PEOPLE_SIGHTINGS,
                    sightingId,
                    superPerson.getSuperPersonId());
        }
    }

    private List<SuperPerson> findSuperPeopleForSighting(Sighting sighting) {
        return jdbcTemplate.query(SQL_SELECT_SUPER_PEOPLE_BY_SIGHTING_ID,
                new SuperPersonMapper(), sighting.getSightingId());

    }
    
    //MAPPER
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sighting_id"));
            s.setLocationId(rs.getInt("location_id"));
            s.setDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
            return s;
        }
    }
}
