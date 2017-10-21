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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class SightingDaoTest {

    private SightingDao sightingDao;
    private SuperPersonDao superPersonDao;
    private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;
    private LocationDao locationDao;

    public SightingDaoTest() {
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
    public void testAddGetDeleteSighting() {
        //ADD A SIGHTING
        //add two super power
        SuperPower flight = new SuperPower();
        flight.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(flight);
        SuperPower gadgets = new SuperPower();
        gadgets.setDescription("High Tech Gadgets");
        superPowerDao.addSuperPower(gadgets);
        assertEquals(2, superPowerDao.getAllSuperPowers().size());
        SuperPower superPowerFromDao = superPowerDao
                .getSuperPowerById(flight.getSuperPowerId());
        assertEquals(superPowerFromDao, flight);
        //add two orgs
        Organization justiceLeague = new Organization();
        justiceLeague.setName("Justice League");
        orgDao.addOrganization(justiceLeague);
        Organization avengers = new Organization();
        avengers.setName("Avengers");
        orgDao.addOrganization(avengers);
        assertEquals(2, orgDao.getAllOrganizations().size());        
        //add two super people
        SuperPerson superMan = new SuperPerson();
        superMan.setName("Superman");
        superMan.setSuperPower(flight);
        List<Organization> orgs = new ArrayList<>();
        orgs.add(justiceLeague);
        orgs.add(avengers);
        superMan.setOrgs(orgs);
        superPersonDao.addSuperPerson(superMan);
        SuperPerson batMan = new SuperPerson();
        batMan.setName("Batman");
        batMan.setDescription("darkness, no parents");
        batMan.setSuperPower(gadgets);
        batMan.setOrgs(orgs);
        superPersonDao.addSuperPerson(batMan);
        assertEquals(2, superPersonDao.getAllSuperPeople().size());
        int spId = superMan.getSuperPersonId();
        SuperPerson superPersonFromDao = superPersonDao.getSuperPersonById(spId);
        assertEquals(superPersonFromDao, superMan);        
        //add a location
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
        Location locationFromDao = locationDao.getLocationById(l.getLocationId());
        assertEquals(locationFromDao, l);
        //add a sighting
        Sighting moaSighting = new Sighting();
        List<SuperPerson> sightingSuperPeople = new ArrayList<>();
        sightingSuperPeople.add(batMan);
        sightingSuperPeople.add(superMan);
        moaSighting.setSuperPeople(sightingSuperPeople);
        moaSighting.setDate(LocalDate.now());
        moaSighting.setLocation(l);
        sightingDao.addSighting(moaSighting);
        
        System.out.println(LocalDate.now());
    }
}
