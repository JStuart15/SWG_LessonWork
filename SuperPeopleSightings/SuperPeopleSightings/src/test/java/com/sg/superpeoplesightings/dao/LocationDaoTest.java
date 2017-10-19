/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
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
public class LocationDaoTest {

    LocationDao dao;

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

        dao = ctx.getBean("locationDao", LocationDao.class);

        //delete all locations
        List<Location> locations = dao.getAllLocations();
        for (Location l : locations) {
            dao.deleteLocation(l.getLocationId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetLocation() {
        Location l = new Location();
        l.setName("Plymouth");
        l.setDescription("City of Plymouth");
        l.setStreet("3635 Wellington Ln N");
        l.setCity("Plymouth");
        l.setState("MN");
        l.setZip("55441");
        l.setPhone("7634126674");
        l.setLatitude(45.023046);
        l.setLongitude(-93.4202007);

        dao.addLocation(l);
        
        Location fromDao = dao.getLocationById(l.getLocationId());
        assertEquals(fromDao, l);
    }

}
