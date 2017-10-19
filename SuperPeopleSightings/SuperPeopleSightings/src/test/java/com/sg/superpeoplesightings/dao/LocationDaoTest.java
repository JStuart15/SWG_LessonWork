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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jstuart15
 */
public class LocationDaoTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddLocation() {
        System.out.println("addLocation");
        Location location = null;
        LocationDao instance = new LocationDaoImpl();
        instance.addLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteLocation() {
        System.out.println("deleteLocation");
        int locationId = 0;
        LocationDao instance = new LocationDaoImpl();
        instance.deleteLocation(locationId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateLocation() {
        System.out.println("updateLocation");
        Location location = null;
        LocationDao instance = new LocationDaoImpl();
        instance.updateLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLocationById() {
        System.out.println("getLocationById");
        int id = 0;
        LocationDao instance = new LocationDaoImpl();
        instance.getLocationById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllLocations() {
        System.out.println("getAllLocations");
        LocationDao instance = new LocationDaoImpl();
        List<Location> expResult = null;
        List<Location> result = instance.getAllLocations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LocationDaoImpl implements LocationDao {

        public void addLocation(Location location) {
        }

        public void deleteLocation(int locationId) {
        }

        public void updateLocation(Location location) {
        }

        public void getLocationById(int id) {
        }

        public List<Location> getAllLocations() {
            return null;
        }
    }
    
}
