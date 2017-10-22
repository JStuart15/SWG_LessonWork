/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPerson;
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
public class PredefinedQueryDaoTest {

    private PredefinedQueryDao queryDao;
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
        queryDao = ctx.getBean("predefinedQueryDao", PredefinedQueryDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testgetAllSuperPeopleByLocationId() {
        List<SuperPerson> superPeople = queryDao.getAllSuperPeopleByLocationId(3);
        superPeople.forEach(sp -> System.out.println(sp.toString()));
        assertEquals(0,0);
    }
}
