/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
import java.util.ArrayList;
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
public class OrganizationDaoTest {

    OrganizationDao orgDao;
    SuperPowerDao superPowerDao;
    SuperPersonDao superPersonDao;

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
        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);

        //delete all organizations which deletes all super_people_organizations
        List<Organization> orgs = orgDao.getAllOrganizations();
        for (Organization currentOrg : orgs) {
            orgDao.deleteOrganization(currentOrg.getOrganizationId());
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetGetAllDeleteOrganization() {
        //ADD & GET ORGANIZATION
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

        assertEquals(shield, shieldFromDao);
        assertEquals(1, orgDao.getAllOrganizations().size());

        //DELETE ORGANIZATION THAT IS USED BY A SUPER PERSON
        //add a super power
        SuperPower flight = new SuperPower();
        flight.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(flight);
        assertEquals(1, superPowerDao.getAllSuperPowers().size());
        SuperPower fromDao = superPowerDao
                .getSuperPowerById(flight.getSuperPowerId());
        assertEquals(fromDao, flight);

        //add super person with the shield org
        SuperPerson sp = new SuperPerson();
        sp.setName("Superman");
        sp.setSuperPower(flight);
        List<Organization> orgs = new ArrayList<>();
        orgs.add(shield);
        sp.setOrgs(orgs);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
        int spId = sp.getSuperPersonId();
        SuperPerson superPersonFromDao = superPersonDao.getSuperPersonById(spId);

        assertEquals(superPersonFromDao, sp);

        //delete the shield org
        orgDao.deleteOrganization(shield.getOrganizationId());
        //we don't delete the super person so the org_id is still 
        //associated with the super person
        assertEquals(1, sp.getOrgs().size());
        assertNull(orgDao.getOrganizationById(shield.getOrganizationId()));
    }

    @Test
    public void testAddGetUpdateOrganization() {
        //ADD & GET ORGANIZATION
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

        assertEquals(shield, shieldFromDao);

        shield.setName("S.H.I.E.L.D");
        shield.setDescription("Strategic Hazard Intervention Espionage Logistics Directorate");
        shield.setStreet("500 Team America Way");
        shield.setCity("Minneapolis");
        shield.setState("MN");
        shield.setZip("55400");
        shield.setPhone("444444444");
        orgDao.updateOrganization(shield);

        Organization updatedShieldFromDao
                = orgDao.getOrganizationById(shield.getOrganizationId());
        
        assertEquals(shield, updatedShieldFromDao);
    }
}
