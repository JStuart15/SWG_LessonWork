/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.messagetemplater.dao.CompanyDao;
import com.sg.messagetemplater.dao.CompanyDaoJsonFileImpl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
        assertNotNull(dao.getAllCompanies());
        assertEquals(5, dao.getAllCompanies().size());
    }

    @Test
    public void testGetCompanyThatExists() {
        assertEquals(2, dao.getCompanyById(2).getId());
        assertEquals("Hotel California", dao.getCompanyById(1).getCompany());
        assertEquals("Torquay", dao.getCompanyById(5).getCity());
    }

    @Test
    public void testGetCompanyThatDoesntExist() {
        assertNull(dao.getCompanyById(6));
    }
}
