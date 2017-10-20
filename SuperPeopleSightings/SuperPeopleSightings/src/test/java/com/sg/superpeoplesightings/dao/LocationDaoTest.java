/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Siting;
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

    LocationDao locationDao;
    SitingDao sitingDao;

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
        sitingDao = ctx.getBean("sitingDao", SitingDao.class);

        //delete all sitings
        List<Siting> sitings = sitingDao.getAllSitings();
        for (Siting s : sitings) {
            sitingDao.deleteSiting(s.getSitingId());
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

}
