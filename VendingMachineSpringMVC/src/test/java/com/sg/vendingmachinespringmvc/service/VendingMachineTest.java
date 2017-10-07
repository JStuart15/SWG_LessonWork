/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDaoStubImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
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
public class VendingMachineTest {

    VendingMachineDao dao = new VendingMachineDaoStubImpl();
    VendingMachine service = new VendingMachineImpl(dao);

    @Inject
    public VendingMachineTest() {
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
    public void testNotEnoughMoney() {
        Map<String, String> purchaseResults = new HashMap<>();
        purchaseResults = service.completePurchase("1", BigDecimal.ZERO);
        assertEquals("false", purchaseResults.get("success"));
        assertEquals("Please deposit: 1.50", purchaseResults.get("message"));
    }

    @Test
    public void testNoItemSelected() {
        Map<String, String> purchaseResults = new HashMap<>();
        purchaseResults = service.completePurchase("", BigDecimal.ZERO);
        assertEquals("false", purchaseResults.get("success"));
        assertEquals("Please select an item", purchaseResults.get("message"));
    }

    @Test
    public void testSuccessfulPurchaseWithChange() {
        Map<String, String> purchaseResults = new HashMap<>();
        purchaseResults = service.completePurchase("1", new BigDecimal(2.90));
        assertEquals("true", purchaseResults.get("success"));
        assertEquals("Thank You!!!", purchaseResults.get("message"));
        assertEquals(0, dao.getItem(1).getQuantityAvailable());
    }

    @Test
    public void testZeroInventoryItem() {
        //tests decrementing the inventory and attempting a purchase with
        //zero inventory
        Map<String, String> purchaseResults = new HashMap<>();
        purchaseResults = service.completePurchase("1", BigDecimal.TEN);
        assertEquals("true", purchaseResults.get("success"));

        purchaseResults = service.completePurchase("1", BigDecimal.TEN);
        assertEquals("false", purchaseResults.get("success"));

    }

    @Test
    public void testChangeReturnNoPurchase() {

    }
}
