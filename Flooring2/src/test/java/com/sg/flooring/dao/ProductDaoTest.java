/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jstuart15
 */
public class ProductDaoTest {
    ProductDao dao = new ProductDaoFileImpl();
    
    public ProductDaoTest() {
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

    /**
     * Test of getAllProducts method, of class ProductDao.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        //@todo - medium - create a test directory and pass that to the Dao to look for the files in there
        assertEquals(5,dao.getAllProducts().size());
    }

    
    
}
