/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

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
    public PredefinedQueryDao(SuperPersonDao superPersonDao, SightingDao sightingDao) {
        this.superPersonDao = superPersonDao;
        this.sightingDao = sightingDao;
        
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_ALL_SUPER_PEOPLE_BY_LOCATION_ID
            = "select distinct s.super_person_id "
            + "from super_people s "
            + "inner join super_people_sightings sps on sps.super_person_id = s.super_person_id "
            + "inner join sightings on sightings.sighting_id = sps.sighting_id "
            + "inner join locations l on l.location_id = sightings.location_id "
            + "where l.location_id = ?";

    public List<SuperPerson> getAllSuperPeopleByLocationId(int id) {
        List<SuperPerson> superPeople = new ArrayList<>();
        List<Integer> superPeopleIds = new ArrayList<>();
        
//        superPeople = jdbcTemplate.query(SQL_ALL_SUPER_PEOPLE_BY_LOCATION_ID, 
//                new SuperPersonMapper(), location.getLocationId());
//        
//        jdbcTemplate.queryForMap(SQL_ALL_SUPER_PEOPLE_BY_LOCATION_ID, 3);
        
        superPeopleIds = jdbcTemplate
                .queryForList(SQL_ALL_SUPER_PEOPLE_BY_LOCATION_ID, 
                        Integer.class, id);
        
        for (Integer superPersonId : superPeopleIds) {
            superPeople.add(superPersonDao.getSuperPersonById(superPersonId));
        }
        return superPeople;

    }
}
