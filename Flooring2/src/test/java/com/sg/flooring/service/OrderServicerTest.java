/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class OrderServicerTest {

    OrderServicer service;

    public OrderServicerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testApplicationContext.xml");
        service = ctx.getBean("serviceLayer", OrderServicer.class);
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
    public void testAddEditRemoveOrder() throws OrderValidationException, FlooringPersistenceException {
        //need to be able to add, edit and delete an order entered on the same day
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(1);
        order.setState("AZ");
        order.setArea(500);
        order.setNextAction("add");
        service.addOrder(order);
        assertEquals(2, service.getAllOrders(LocalDate.now()).size());
        assertEquals(1, service.getTransactions().size());

        order.setCustName("Walmart");
        service.editOrder(order);
        assertEquals(2, service.getAllOrders(LocalDate.now()).size());
        assertEquals(1, service.getTransactions().size());//one transaction because we replace the add with an edit
        assertEquals("edit", order.getNextAction());
        assertEquals("Walmart", order.getCustName());

        service.removeOrder(LocalDate.now(), 1);
        assertEquals(1, service.getAllOrders(LocalDate.now()).size());
        assertEquals(1, service.getTransactions().size());//one transaction because replace the edit with a remove
        assertEquals("remove", order.getNextAction());

    }

    @Test
    public void testAddValidOrderAndClearTransactions() throws Exception {
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(2);
        order.setState("AZ");
        order.setArea(500);
        service.addOrder(order);
        assertEquals(0, order.getErrors().stream().count());
        assertEquals(2, service.getAllOrders(LocalDate.now()).size());
        service.clearTransactions();
        assertEquals(0, service.getTransactions().size());
    }

    @Test
    public void testAddOrder_BlankCustomerName() throws Exception {
        Order order = new Order(1);
        order.setCustName("");
        order.setProductId(3);
        order.setState("MN");
        order.setArea(50.5);
        service.addOrder(order);
        assertEquals(1, order.getErrors().stream().count());
        assertEquals("Customer name can't be blank", order.getErrors().stream().findFirst().orElse("none"));
    }

    @Test
    public void testAddOrder_NoArea() throws Exception {
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(1);
        order.setState("MN");
        service.addOrder(order);
        assertEquals(1, order.getErrors().stream().count());
        assertEquals("Area is less than or equal to 0", order.getErrors().stream().findFirst().orElse("none"));
    }

    @Test
    public void testAddOrder_AreaLessThanZero() throws Exception {
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(2);
        order.setState("MN");
        order.setArea(-50.5);
        service.addOrder(order);
        assertEquals(1, order.getErrors().stream().count());
        assertEquals("Area is less than or equal to 0", order.getErrors().stream().findFirst().orElse("none"));
    }

    @Test
    public void testAddOrder_AreaOfZero() throws Exception {
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(3);
        order.setState("MN");
        order.setArea(0);
        service.addOrder(order);
        assertEquals(1, order.getErrors().stream().count());
        assertEquals("Area is less than or equal to 0", order.getErrors().stream().findFirst().orElse("none"));
    }

    @Test
    public void testValidate_OrderWrongProduct() throws Exception {
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(55);
        order.setState("AZ");
        order.setArea(50.5);
        service.addOrder(order);
        assertEquals(1, order.getErrors().stream().count());
        assertEquals("Product does not exist", order.getErrors().stream().findFirst().orElse("none"));
    }

    @Test
    public void testCalculateOrderValues() throws Exception {
        //laborCostPsf = 3.25; matCostPsf = 2.25; taxRate = 7.25;
        //laborCost = 164.13; matCost = 113.63; tax = 20.14 Total = 297.90
        Order order = new Order(1);
        order.setCustName("Bob Smith");
        order.setProductId(4);
        order.setState("MN");
        order.setArea(50.5);
        service.addOrder(order);
        assertEquals(new BigDecimal(297.90)
                .setScale(2, RoundingMode.HALF_UP), order.getTotalCost());
    }

    @Test
    public void testGetNextOrderNumberForToday() throws Exception {
        //order number in Dao stub is 1001, expect 1002
        assertEquals(1002, service.getNextOrderNumberForToday());
    }

    @Test
    public void testGetOrder() throws Exception {
//        Order order = service.getOrder(LocalDate.now(), 1);
//        assertTrue(order.getCustName().equals("Walmart"));
    }
    
    @Test
    public void testSaveCurrentWork() throws Exception {

    }

    @Test
    public void testHasOrdersOnDate() throws FlooringPersistenceException {
        assertTrue(service.hasOrdersOnDate(LocalDate.now()));

    }

    @Test
    public void testHasAnOrderOnDate() throws Exception {
        assertTrue(service.hasAnOrderOnDate(1001l, LocalDate.now()));
    }

}
