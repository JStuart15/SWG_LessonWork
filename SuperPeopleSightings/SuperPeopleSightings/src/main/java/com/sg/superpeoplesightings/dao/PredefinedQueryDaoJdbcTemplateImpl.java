/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jstuart15
 */
public class PredefinedQueryDaoJdbcTemplateImpl implements PredefinedQueryDao{

    SuperPersonDao superPersonDao;
    private SightingDao sightingDao;
    //private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;
    private LocationDao locationDao;

    @Inject
    public PredefinedQueryDaoJdbcTemplateImpl(SuperPersonDao superPersonDao,
            SightingDao sightingDao, LocationDao locationDao,
            OrganizationDao orgDao) {
        this.superPersonDao = superPersonDao;
        this.sightingDao = sightingDao;
        this.locationDao = locationDao;
        this.orgDao = orgDao;
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
            //@todo - should this be distinct because date is not included in query
            //and duplicates show up.  Wait for additional requirements.
            = "select l.location_id "
            + "from locations l "
            + "inner join sightings s on s.location_id = l.location_id "
            + "inner join super_people_sightings sps on sps.sighting_id = s.sighting_id "
            + "inner join super_people sp on sps.super_person_id = sp.super_person_id "
            + "where sp.super_person_id = ?";

    private static final String SQL_ALL_SIGHTINGS_FOR_A_DATE
            = "select distinct s.sighting_id from sightings s where s.date = ?";

    private static final String SQL_ALL_SUPER_PEOPLE_FOR_A_ORG
            = "select sp.super_person_id "
            + "from super_people sp "
            + "inner join super_people_organizations spo on spo.super_person_id = sp.super_person_id "
            + "inner join organizations o on o.organization_id = spo.organization_id "
            + "where o.organization_id = ?";

    private static final String SQL_ALL_ORGS_FOR_A_SUPER_PERSON
            = "select o.organization_id "
            + "from organizations o "
            + "inner join super_people_organizations spo on spo.organization_id = o.organization_id "
            + "inner join super_people sp on sp.super_person_id = spo.super_person_id "
            + "where sp.super_person_id = ?";

    //METHODS
    @Override
    public List<SuperPerson> getAllSuperPeopleForALocation(int locationId) {
        List<SuperPerson> superPeople = new ArrayList<>();
        List<Integer> superPeopleIds = new ArrayList<>();

        superPeopleIds = jdbcTemplate
                .queryForList(SQL_ALL_SUPER_PEOPLE_FOR_A_LOCATION,
                        Integer.class, locationId);

        for (Integer superPersonId : superPeopleIds) {
            superPeople.add(superPersonDao.getSuperPersonById(superPersonId));
        }
        return superPeople;
    }

    @Override
    public List<Location> getAllLocationsForASuperPerson(int spId) {
        List<Location> locationsSeen = new ArrayList<>();
        List<Integer> locationSeenIds = new ArrayList<>();

        locationSeenIds = jdbcTemplate
                .queryForList(SQL_ALL_LOCATIONS_FOR_A_SUPER_PERSON,
                        Integer.class, spId);

        for (Integer locationSeenId : locationSeenIds) {
            locationsSeen.add(locationDao.getLocationById(locationSeenId));
        }
        return locationsSeen;
    }

    @Override
    public List<Sighting> getAllSightingsForADate(LocalDate now) {
        List<Sighting> sightings = new ArrayList<>();
        List<Integer> sightingsIds = new ArrayList<>();

        sightingsIds = jdbcTemplate.queryForList(SQL_ALL_SIGHTINGS_FOR_A_DATE,
                Integer.class, now.toString());

        for (Integer sightingsId : sightingsIds) {
            sightings.add(sightingDao.getSightingById(sightingsId));
        }
        return sightings;
    }

    @Override
    public List<SuperPerson> getAllSuperPeopleForAnOrg(int orgId) {
        List<SuperPerson> superPeople = new ArrayList<>();
        List<Integer> superPeopleIds = new ArrayList<>();

        superPeopleIds = jdbcTemplate
                .queryForList(SQL_ALL_SUPER_PEOPLE_FOR_A_ORG,
                        Integer.class, orgId);

        for (Integer superPersonId : superPeopleIds) {
            superPeople.add(superPersonDao.getSuperPersonById(superPersonId));
        }
        return superPeople;
    }

    @Override
    public List<Organization> getAllOrgsForASuperPerson(int spId) {
        List<Organization> orgs = new ArrayList<>();
        List<Integer> orgIds = new ArrayList<>();

        orgIds = jdbcTemplate.queryForList(SQL_ALL_ORGS_FOR_A_SUPER_PERSON,
                Integer.class, spId);

        for (Integer orgId : orgIds) {
            orgs.add(orgDao.getOrganizationById(orgId));
        }
        return orgs;
    }
}
