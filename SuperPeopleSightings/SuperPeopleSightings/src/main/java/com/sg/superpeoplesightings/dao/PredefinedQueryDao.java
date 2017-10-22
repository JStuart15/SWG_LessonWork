/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jstuart15
 */
public class PredefinedQueryDao {

    SuperPersonDao superPersonDao;
    private SightingDao sightingDao;
    private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;
    private LocationDao locationDao;

    @Inject
    public PredefinedQueryDao(SuperPersonDao superPersonDao, 
            SightingDao sightingDao,
            LocationDao locationDao) {
        this.superPersonDao = superPersonDao;
        this.sightingDao = sightingDao;
        this.locationDao = locationDao;

    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_ALL_SUPER_PEOPLE_FOR_A_LOCATION
            = "select distinct s.super_person_id "
            + "from super_people s "
            + "inner join super_people_sightings sps on sps.super_person_id = s.super_person_id "
            + "inner join sightings on sightings.sighting_id = sps.sighting_id "
            + "inner join locations l on l.location_id = sightings.location_id "
            + "where l.location_id = ? "
            + "order by s.super_person_id";

    private static final String SQL_ALL_LOCATIONS_FOR_A_SUPER_PERSON
            = "select l.location_id "
            + "from locations l "
            + "inner join sightings s on s.location_id = l.location_id "
            + "inner join super_people_sightings sps on sps.sighting_id = s.sighting_id "
            + "inner join super_people sp on sps.super_person_id = sp.super_person_id "
            + "where sp.super_person_id = ?";

    //METHODS
    public List<SuperPerson> getAllSuperPeopleForALocation(Location location) {
        List<SuperPerson> superPeople = new ArrayList<>();
        List<Integer> superPeopleIds = new ArrayList<>();

        superPeopleIds = jdbcTemplate
                .queryForList(SQL_ALL_SUPER_PEOPLE_FOR_A_LOCATION,
                        Integer.class, location.getLocationId());

        for (Integer superPersonId : superPeopleIds) {
            superPeople.add(superPersonDao.getSuperPersonById(superPersonId));
        }
        return superPeople;
    }

    public List<Location> getAllLocationsForASuperPerson(SuperPerson sp) {
        List<Location> locationsSeen = new ArrayList<>();
        List<Integer> locationSeenIds = new ArrayList<>();

        locationSeenIds = jdbcTemplate
                .queryForList(SQL_ALL_LOCATIONS_FOR_A_SUPER_PERSON,
                        Integer.class, sp.getSuperPersonId());
        
        for (Integer locationSeenId : locationSeenIds) {
            locationsSeen.add(locationDao.getLocationById(locationSeenId));
        }
        return locationsSeen;
    }
}
