/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplate.dao;

import com.sg.messagetemplate.model.Company;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jstuart15
 */
public class CompanyDaoTest {

    CompanyDao dao = new CompanyDaoJsonFileImpl();

    public CompanyDaoTest() {
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
    public void testGetAllCompanies() {

        List<Company> companyList = dao.getAllCompanies();
        assertNotNull(dao.getAllCompanies());
        assertEquals(5, dao.getAllCompanies().size());
    }
}
