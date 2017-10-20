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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class SuperPersonDaoTest {

    SuperPersonDao superPersonDao;
    SuperPowerDao superPowerDao;
    OrganizationDao orgDao;

    public SuperPersonDaoTest() {
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

        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdd_Get_GetAll_Delete_SuperPerson() {
        assertEquals(0, superPersonDao.getAllSuperPeople().size());

        //add a super power
        SuperPower superPower = new SuperPower();
        superPower.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(superPower);
        assertEquals(1, superPowerDao.getAllSuperPowers().size());

        //add 2 organizations
        Organization org = new Organization();
        org.setName("Justice League");
        orgDao.addOrganization(org);

        Organization org2 = new Organization();
        org2.setName("Avengers");
        orgDao.addOrganization(org2);
        assertEquals(2, orgDao.getAllOrganizations().size());

        //add super person
        SuperPerson sp = new SuperPerson();
        sp.setName("Superman");
        sp.setSuperPowerId(superPower.getSuperPowerId());
        List<Organization> orgs = new ArrayList<>();
        orgs.add(org);
        orgs.add(org2);
        sp.setOrgs(orgs);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
        
        SuperPerson fromDao = superPersonDao.getSuperPeopleById(sp.getSuperPersonId());
        assertEquals(fromDao, sp);
    }
}
