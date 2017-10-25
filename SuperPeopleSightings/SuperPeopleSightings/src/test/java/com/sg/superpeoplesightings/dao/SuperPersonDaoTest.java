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

    private SuperPersonDao superPersonDao;
    private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;

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
        SuperPower fromDao = superPowerDao
                .getSuperPowerById(superPower.getSuperPowerId());
        assertEquals(fromDao, superPower);

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
        sp.setSuperPower(superPower);
        List<Organization> orgs = new ArrayList<>();
        orgs.add(org);
        orgs.add(org2);
        sp.setOrgs(orgs);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
        int spId = sp.getSuperPersonId();
        SuperPerson superPersonFromDao = superPersonDao.getSuperPersonById(spId);

        assertEquals(superPersonFromDao, sp);
    }

    @Test
    public void testAddSuperPersonNoSuperPower() {
        //we want this to be allowed
        assertEquals(0, superPersonDao.getAllSuperPeople().size());
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
        List<Organization> orgs = new ArrayList<>();
        orgs.add(org);
        orgs.add(org2);
        sp.setOrgs(orgs);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
    }

    @Test
    public void testAddUpdateSuperPerson() {
        assertEquals(0, superPersonDao.getAllSuperPeople().size());

        //add a super power
        SuperPower superPower = new SuperPower();
        superPower.setDescription("High Tech Gadgets");
        superPowerDao.addSuperPower(superPower);
        assertEquals(1, superPowerDao.getAllSuperPowers().size());
        SuperPower fromDao = superPowerDao
                .getSuperPowerById(superPower.getSuperPowerId());
        assertEquals(fromDao, superPower);

        //add another super power
        SuperPower superPower2 = new SuperPower();
        superPower2.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(superPower2);
        assertEquals(2, superPowerDao.getAllSuperPowers().size());
        SuperPower superPowerFromDao = superPowerDao
                .getSuperPowerById(superPower.getSuperPowerId());
        assertEquals(superPowerFromDao, superPower);

        //add 2 organizations
        Organization org = new Organization();
        org.setName("Justice League");
        orgDao.addOrganization(org);

        Organization org2 = new Organization();
        org2.setName("Avengers");
        orgDao.addOrganization(org2);
        assertEquals(2, orgDao.getAllOrganizations().size());

        //add super person, one org
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setSuperPower(superPower2); //wrong super power for Batman
        List<Organization> orgs = new ArrayList<>();
        orgs.add(org2); //wrong org for Batman
        sp.setOrgs(orgs);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
        SuperPerson superPersonFromDao = superPersonDao
                .getSuperPersonById(sp.getSuperPersonId());
        assertEquals(superPersonFromDao, sp);
        assertEquals("Avengers", superPersonFromDao
                .getOrgs().get(0).getName());
        assertEquals("Supersonic Flight", superPersonFromDao
                .getSuperPower().getDescription());

        //Change name, org and superpower
        sp.setName("Batman 2017");
        sp.setSuperPower(superPower); //high tech gadgets
        orgs.clear();
        orgs.add(org);//Justice League
        sp.setOrgs(orgs);
        superPersonDao.updateSuperPerson(sp);
        SuperPerson Batman2017 = superPersonDao
                .getSuperPersonById(sp.getSuperPersonId());
        assertEquals("Batman 2017", Batman2017.getName());
        assertEquals("Justice League", Batman2017.getOrgs().get(0).getName());
        assertEquals("High Tech Gadgets", Batman2017.getSuperPower().getDescription());
        assertEquals(Batman2017, sp);

    }

    @Test
    public void testAddSuperPersonNoOrgs() {
        //adding super person without orgs should be allowed
        assertEquals(0, superPersonDao.getAllSuperPeople().size());

        //add a super power
        SuperPower superPower = new SuperPower();
        superPower.setDescription("Supersonic Flight");
        superPowerDao.addSuperPower(superPower);
        assertEquals(1, superPowerDao.getAllSuperPowers().size());
        SuperPower fromDao = superPowerDao
                .getSuperPowerById(superPower.getSuperPowerId());
        assertEquals(fromDao, superPower);

        //add super person
        SuperPerson sp = new SuperPerson();
        sp.setName("Superman");
        sp.setSuperPower(superPower);
        superPersonDao.addSuperPerson(sp);
        assertEquals(1, superPersonDao.getAllSuperPeople().size());
        int spId = sp.getSuperPersonId();
        SuperPerson superPersonFromDao = superPersonDao.getSuperPersonById(spId);
        superPersonFromDao.setOrgs(null);//need to set to null because it comes back from db as size 0
        assertEquals(superPersonFromDao, sp);
    }
}
