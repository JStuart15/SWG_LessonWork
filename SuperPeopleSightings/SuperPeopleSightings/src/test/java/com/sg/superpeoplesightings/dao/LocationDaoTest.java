/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Sighting;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class LocationDaoTest {

    private LocationDao locationDao;
    private SightingDao sightingDao;

    public LocationDaoTest() {
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

        locationDao = ctx.getBean("locationDao", LocationDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);

        //delete all sitings, which deletes super_people_sightings
        List<Sighting> sighting = sightingDao.getAllSightings();
        for (Sighting s : sighting) {
            sightingDao.deleteSighting(s.getSightingId());
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
    public void testAddGetDeleteLocation() {
        Location l = new Location();
        l.setName("Plymouth");
        l.setDescription("City of Plymouth");
        l.setStreet("3635 Wellington Ln N");
        l.setCity("Plymouth");
        l.setState("MN");
        l.setZip("55441");
        l.setLatitude(45.023046);
        l.setLongitude(-93.4202007);
        l.setIsActive(1);

        locationDao.addLocation(l);

        Location fromDao = locationDao.getLocationById(l.getLocationId());
        assertEquals(fromDao, l);

        locationDao.deleteLocation(l.getLocationId());
        assertNull(locationDao.getLocationById(l.getLocationId()));
    }

    @Test
    public void testAddUpdateLocation() {
        Location l = new Location();
        l.setName("Plymouth");
        l.setDescription("City of Plymouth");
        l.setStreet("3635 Wellington Ln N");
        l.setCity("Plymouth");
        l.setState("MN");
        l.setZip("55441");
        l.setLatitude(45.023046);
        l.setLongitude(-93.4202007);
        l.setIsActive(1);

        locationDao.addLocation(l);

        Location fromDao = locationDao.getLocationById(l.getLocationId());
        assertEquals(fromDao, l);
        assertEquals(fromDao.getCity(), "Plymouth");

        //@todo expand the changes here
        l.setCity("Minneapolis");
        locationDao.updateLocation(l);

        Location fromDao2 = locationDao.getLocationById(l.getLocationId());
        assertEquals(fromDao2, l);
    }

    @Test
    public void testGetAllLocations() {
        Location l = new Location();
        l.setName("Plymouth");
        l.setDescription("City of Plymouth");
        l.setStreet("3635 Wellington Ln N");
        l.setCity("Plymouth");
        l.setState("MN");
        l.setZip("55441");
        l.setLatitude(45.023046);
        l.setLongitude(-93.4202007);
        l.setIsActive(1);

        locationDao.addLocation(l);

        Location l2 = new Location();
        l2.setName("MOA");
        l2.setDescription("Mall of America");
        l2.setStreet("1234 American Way");
        l2.setCity("Bloomington");
        l2.setState("MN");
        l2.setZip("55111");
        l2.setLatitude(44.023046);
        l2.setLongitude(-94.4202007);
        l2.setIsActive(1);

        locationDao.addLocation(l2);
        
        assertEquals(2, locationDao.getAllLocations().size());
    }
}
