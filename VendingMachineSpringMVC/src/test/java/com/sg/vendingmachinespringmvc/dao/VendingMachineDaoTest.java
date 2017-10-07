/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class VendingMachineDaoTest {

    private VendingMachineDao dao = new VendingMachineDaoInMemImpl();

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
    
    @Test
    public void testUpdateItem() {
        assertEquals(9, dao.getItem(1).getQuantityAvailable());
        
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItemName("Snickers");
        item1.setItemCost(new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP));
        item1.setQuantityAvailable(8);
        dao.updateItem(item1);
        
        assertEquals(8, dao.getItem(1).getQuantityAvailable());
    }
    
}
