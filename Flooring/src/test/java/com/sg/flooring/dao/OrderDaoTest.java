/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class OrderDaoTest {

    private OrderDao dao = new OrderProdDaoFileImpl();

    public OrderDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FlooringPersistenceException, IOException {
        //make a directory in project folder to hold our files
        String ordersDirectory = "./flooringFiles/";
        String ordersFileName = "Orders_"
                + LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy"))
                + ".txt";
        File newDir = new File("./", ordersDirectory);
        newDir.mkdir();
        File newFile = new File(ordersDirectory, ordersFileName);
        Order order1 = new Order(1);
        order1.setCustName("Walmart");
        order1.setState("MN");
        order1.setTaxRate(new BigDecimal("6.25"));
        order1.setProductId(3);
        order1.setProductName("Laminate");
        order1.setArea(6.25);
        order1.setMaterialCostPsf(new BigDecimal("5.25"));
        order1.setLaborCostPsf(new BigDecimal("4.25"));
        order1.setMaterialCost(new BigDecimal("500"));
        order1.setLaborCost(new BigDecimal("500"));
        order1.setTax(new BigDecimal("100"));
        order1.setTotalCost(new BigDecimal("1100"));
        order1.setOrderDate(LocalDate.now());

        dao.addOrder(order1);

        Order order2 = new Order(2);
        order2.setCustName("Target");
        order2.setState("OH");
        order2.setTaxRate(new BigDecimal("1.25"));
        order2.setProductId(2);
        order2.setProductName("Cork");
        order2.setArea(3.25);
        order2.setMaterialCostPsf(new BigDecimal("1.25"));
        order2.setLaborCostPsf(new BigDecimal("2.25"));
        order2.setMaterialCost(new BigDecimal("250"));
        order2.setLaborCost(new BigDecimal("250"));
        order2.setTax(new BigDecimal("100"));
        order2.setTotalCost(new BigDecimal("600"));
        order2.setOrderDate(LocalDate.now());
        dao.addOrder(order2);
    }

    @After
    public void tearDown() {
        String ordersDirectory = "./flooringFiles/";
        String ordersFileName = "Orders_"
                + LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy"))
                + ".txt";
        File newDir = new File("./", ordersDirectory);
        newDir.mkdir();
        File newFile = new File(ordersDirectory, ordersFileName);
        newFile.deleteOnExit();
    }

    @Test
    public void testGetOrder() throws Exception {
        Order order1 = dao.getOrder(LocalDate.now(), 1);
        assertEquals("WALMART", order1.getCustName());
    }

    @Test
    public void testGetAllOrders() throws Exception {
        assertEquals(2, dao.getAllOrders(LocalDate.now()).size());
    }

    @Test
    public void testRemoveOrder() throws FlooringPersistenceException {
        Order order = dao.getOrder(LocalDate.now(), 1);
        order.setOrderDate(LocalDate.now());
        dao.removeOrder(order);

        assertEquals(1, dao.getAllOrders(LocalDate.now()).size());
    }

    @Test
    public void testEditOrder() throws FlooringPersistenceException {
        Order order = dao.getOrder(LocalDate.now(), 2);
        order.setCustName("jcpenny");
        order.setOrderDate(LocalDate.now());
        dao.editOrder(order);
        assertEquals("JCPENNY", dao.getOrder(LocalDate.now(), 2).getCustName());
        assertEquals(2, dao.getAllOrders(LocalDate.now()).size());

    }
}
