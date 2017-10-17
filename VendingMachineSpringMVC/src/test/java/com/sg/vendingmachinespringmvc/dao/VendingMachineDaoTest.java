/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

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
public class VendingMachineDaoTest {

    private VendingMachineDao dao;

    public VendingMachineDaoTest() {
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

        dao = ctx.getBean("vendingMachineDao", VendingMachineDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllItems() {
        assertEquals(9, dao.getAllItems().size());
    }

    @Test
    public void testGetItem() {
        assertEquals("Snickers", dao.getItem(1).getItemName());
    }

//    @Test
//    public void testUpdateItem() {
//        assertEquals(8, dao.getItem(1).getQuantityAvailable());
//
//        Item item1 = new Item();
//        item1.setItemId(1);
//        item1.setItemName("Snickers");
//        item1.setItemCost(new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP));
//        item1.setQuantityAvailable(8);
//        dao.updateItem(item1);
//
//        assertEquals(7, dao.getItem(1).getQuantityAvailable());
//    }

}
