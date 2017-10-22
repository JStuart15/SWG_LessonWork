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
import com.sg.superpeoplesightings.model.SuperPower;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class PredefinedQueryDaoTest {

    private PredefinedQueryDaoJdbcTemplateImpl queryDao;
    private SuperPersonDao superPersonDao;
    private SightingDao sightingDao;
    private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;
    private LocationDao locationDao;

    public PredefinedQueryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);
        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);
        queryDao = ctx.getBean("predefinedQueryDao", PredefinedQueryDaoJdbcTemplateImpl.class);

        //delete sightings, which deletes all super_people_sightings
        List<Sighting> sightings = sightingDao.getAllSightings();
        for (Sighting s : sightings) {
            sightingDao.deleteSighting((s.getSightingId()));
        }

        //delete all organizations
        List<Organization> orgs = orgDao.getAllOrganizations();
        for (Organization org : orgs) {
            orgDao.deleteOrganization(org.getOrganizationId());
        }

        //delete all super_people records which will delete super_people_organizations
        //and super_people_sitings
        List<SuperPerson> superPeople = superPersonDao.getAllSuperPeople();
        for (SuperPerson sp : superPeople) {
            superPersonDao.deleteSuperPerson(sp.getSuperPersonId());
        }

        //delete all super_power records
        List<SuperPower> superPowers = superPowerDao.getAllSuperPowers();
        for (SuperPower superPower : superPowers) {
            superPowerDao.deleteSuperPower(superPower.getSuperPowerId());
        }

        //delete all locations
        List<Location> locations = locationDao.getAllLocations();
        for (Location l : locations) {
            locationDao.deleteLocation(l.getLocationId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAllPredefinedQueries() {
        //add three super powers
        SuperPower flight = new SuperPower();
        flight.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(flight);
        SuperPower gadgets = new SuperPower();
        gadgets.setDescription("High Tech Gadgets");
        superPowerDao.addSuperPower(gadgets);
        SuperPower strength = new SuperPower();
        strength.setDescription("Super human strength");
        superPowerDao.addSuperPower(strength);

        //add two orgs
        Organization justiceLeague = new Organization();
        justiceLeague.setName("Justice League");
        orgDao.addOrganization(justiceLeague);
        Organization avengers = new Organization();
        avengers.setName("Avengers");
        orgDao.addOrganization(avengers);

        //add four super people
        SuperPerson superMan = new SuperPerson();
        superMan.setName("Superman");
        superMan.setDescription("alien in human form");
        superMan.setSuperPower(flight);
        List<Organization> superPersonOrg = new ArrayList<>();
        superPersonOrg.add(justiceLeague);
        superMan.setOrgs(superPersonOrg);
        superPersonDao.addSuperPerson(superMan);

        SuperPerson batMan = new SuperPerson();
        batMan.setName("Batman");
        batMan.setDescription("darkness, no parents");
        batMan.setSuperPower(gadgets);
        batMan.setOrgs(superPersonOrg);
        superPersonDao.addSuperPerson(batMan);

        SuperPerson hulk = new SuperPerson();
        hulk.setName("Hulk");
        hulk.setDescription("angry green dude");
        hulk.setSuperPower(strength);
        List<Organization> superPersonOrg2 = new ArrayList<>();
        superPersonOrg2.add(avengers);
        hulk.setOrgs(superPersonOrg2);
        superPersonDao.addSuperPerson(hulk);

        SuperPerson ironMan = new SuperPerson();
        ironMan.setName("IronMan");
        ironMan.setDescription("no parents");
        ironMan.setSuperPower(gadgets);
        ironMan.setOrgs(superPersonOrg2);
        superPersonDao.addSuperPerson(ironMan);

        //add two locations
        Location l = new Location();
        l.setName("MOA");
        l.setDescription("Mall of America");
        l.setStreet("2000 American Way");
        l.setCity("Bloomington");
        l.setState("MN");
        l.setZip("55300");
        l.setLatitude(55.023046);
        l.setLongitude(-83.4202007);
        l.setIsActive(1);
        locationDao.addLocation(l);

        Location l2 = new Location();
        l2.setName("Movie Theatre");
        l2.setDescription("eMagine");
        l2.setStreet("00 Movie Way");
        l2.setCity("Springfield");
        l2.setState("IL");
        l2.setZip("12345");
        l2.setLatitude(15.023046);
        l2.setLongitude(-13.4202007);
        l2.setIsActive(1);
        locationDao.addLocation(l2);

        //add sightings
        Sighting moaSighting = new Sighting();
        List<SuperPerson> moaSightingSp = new ArrayList<>();
        moaSightingSp.add(superMan);
        moaSightingSp.add(batMan);
        moaSighting.setSuperPeople(moaSightingSp);
        moaSighting.setDate(LocalDate.now());
        moaSighting.setLocation(l2);
        sightingDao.addSighting(moaSighting);

        Sighting movieSighting = new Sighting();
        List<SuperPerson> movieSightingSp = new ArrayList<>();
        movieSightingSp.add(superMan);
        movieSightingSp.add(batMan);
        movieSightingSp.add(hulk);
        movieSightingSp.add(ironMan);
        movieSighting.setSuperPeople(movieSightingSp);
        movieSighting.setDate(LocalDate.now());
        movieSighting.setLocation(l);
        sightingDao.addSighting(movieSighting);

        //TEST GET ALL SUPER PEOPLE SEEN FOR A LOCATION
        //test location l which has 4 heroes
        List<SuperPerson> superPeopleFromDao = queryDao.getAllSuperPeopleForALocation(l.getLocationId());
        //superPeopleFromDao.forEach(sp -> System.out.println(sp.toString()));
        assertEquals(4, superPeopleFromDao.size());
        assertEquals(movieSightingSp, superPeopleFromDao);

        //test location l2 which has 2 heroes
        List<SuperPerson> superPeopleFromDao2 = queryDao.getAllSuperPeopleForALocation(l2.getLocationId());
        //superPeopleFromDao2.forEach(sp -> System.out.println(sp.toString()));
        assertEquals(2, superPeopleFromDao2.size());
        assertEquals(moaSightingSp, superPeopleFromDao2);

        //TEST GET ALL LOCATIONS FOR A SUPER PERSON
        //test superman seen at two locations
        List<Location> locationsFromDao = queryDao.getAllLocationsForASuperPerson(superMan);
        assertEquals(2, locationsFromDao.size());
        assertTrue(locationsFromDao.contains(l2));
        assertTrue(locationsFromDao.contains(l));

        //test hulk, only seen at location l
        List<Location> locationsFromDao2 = queryDao.getAllLocationsForASuperPerson(hulk);
        assertEquals(1, locationsFromDao2.size());
        assertFalse(locationsFromDao2.contains(l2));
        assertTrue(locationsFromDao2.contains(l));

        //TEST GET ALL SIGHTINGS FOR A DATE
        List<Sighting> sightingsFromDao
                = queryDao.getAllSightingsForADate(LocalDate.now());
        assertEquals(2, sightingsFromDao.size());
        //test that sighting is fully formed
        //sightingsFromDao.forEach(sp -> System.out.println(sp.toString()));
        assertTrue(sightingsFromDao.contains(movieSighting));
        assertTrue(sightingsFromDao.contains(moaSighting));
        
        //TEST GET ALL SUPER PEOPLE FOR AN ORGANIZATION
        List<SuperPerson> avengersFromDao = 
                queryDao.getAllSuperPeopleForAnOrg(avengers);
        assertEquals(2, avengersFromDao.size());
        assertTrue(avengersFromDao.contains(ironMan));
        assertFalse(avengersFromDao.contains(batMan));
        
        //TEST GET ALL ORGANIZATIONS FOR A SUPER PERSON
        List<Organization> orgsFromDao = 
                queryDao.getAllOrgsForASuperPerson(ironMan);
        assertEquals(1, orgsFromDao.size());
        assertTrue(orgsFromDao.contains(avengers));
        assertFalse(orgsFromDao.contains(justiceLeague));
    }
}
