/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Organization;
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
public class OrganizationDaoTest {

    OrganizationDao orgDao;

    public OrganizationDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);

        //delete all organizations which deletes all super_people_organizations
        List<Organization> orgs = orgDao.getAllOrganizations();
        for (Organization currentOrg : orgs) {
            orgDao.deleteOrganization(currentOrg.getOrganizationId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetDeleteOrganization() {
        Organization shield = new Organization();
        shield.setName("SHIELD");
        shield.setDescription("super hero org");
        shield.setStreet("1000 Team America Way");
        shield.setCity("New York");
        shield.setState("NY");
        shield.setZip("10010");
        shield.setPhone("555555555");

        orgDao.addOrganization(shield);

        Organization shieldFromDao = orgDao
                .getOrganizationById(shield.getOrganizationId());

        assertEquals(shield.getCity(),shieldFromDao.getCity());
        
    }
}
