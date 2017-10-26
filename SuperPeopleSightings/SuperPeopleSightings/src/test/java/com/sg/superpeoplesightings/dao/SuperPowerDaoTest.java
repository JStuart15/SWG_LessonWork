/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
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
public class SuperPowerDaoTest {

    private SuperPowerDao superPowerDao;
    private SuperPersonDao superPersonDao;

    public SuperPowerDaoTest() {
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

        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);

        //delete all super people which deletes super_people_sightings
        // and super_people_organizations
        List<SuperPerson> superPeople = superPersonDao.getAllSuperPeople();
        for (SuperPerson sp : superPeople) {
            superPersonDao.deleteSuperPerson(sp.getSuperPersonId());
        }

        //delete all super powers
        List<SuperPower> superPowers = superPowerDao.getAllSuperPowers();
        for (SuperPower sp : superPowers) {
            superPowerDao.deleteSuperPower(sp.getSuperPowerId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdd_Get_GetAll_DeleteSuperPower() {
        assertEquals(0, superPowerDao.getAllSuperPowers().size());

        SuperPower sp = new SuperPower();
        sp.setDescription("Flight");

        superPowerDao.addSuperPower(sp);
        assertEquals(1, superPowerDao.getAllSuperPowers().size());
        
        SuperPower fromDao = superPowerDao.getSuperPowerById(sp.getSuperPowerId());
        assertEquals(fromDao, sp);

        superPowerDao.deleteSuperPower(sp.getSuperPowerId());
        //assertNull(superPowerDao.getSuperPowerById(sp.getSuperPowerId()));
        assertEquals(0, superPowerDao.getAllSuperPowers().size());
    }

    @Test
    public void testAddUpdateSuperPower() {
        assertEquals(0, superPowerDao.getAllSuperPowers().size());

        SuperPower sp = new SuperPower();
        sp.setDescription("Flight");
        superPowerDao.addSuperPower(sp);

        SuperPower fromDao = superPowerDao.getSuperPowerById(sp.getSuperPowerId());
        assertEquals(fromDao, sp);

        sp.setDescription("Supersonic Flight");
        superPowerDao.updateSuperPower(sp);
        
        SuperPower fromDao2 = superPowerDao.getSuperPowerById(sp.getSuperPowerId());
        assertEquals(fromDao2, sp);
    }
}
