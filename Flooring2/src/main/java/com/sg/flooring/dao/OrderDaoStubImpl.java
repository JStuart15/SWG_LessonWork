/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Stub to be used for testing.
 *
 * @author jstuart15
 */
public class OrderDaoStubImpl implements OrderDao {

    Order onlyOrder;
    Map<Long, Order> orderList = new HashMap<>();

    public OrderDaoStubImpl() {
        Order onlyOrder = new Order(1001);
        onlyOrder.setCustName("Walmart");
        onlyOrder.setArea(550);
        onlyOrder.setError("This order has an error");
        onlyOrder.setLaborCost(new BigDecimal(1000));
        onlyOrder.setLaborCostPsf(new BigDecimal(4.25));
        onlyOrder.setMaterialCost(new BigDecimal(1000));
        onlyOrder.setMaterialCostPsf(new BigDecimal(5.25));
        onlyOrder.setNextAction("add");
        onlyOrder.setOrderDate(LocalDate.now());
        onlyOrder.setProductId(1);
        onlyOrder.setProductName("carpet");
        onlyOrder.setState("mn");
        onlyOrder.setTax(new BigDecimal(15));
        onlyOrder.setTaxRate(new BigDecimal(6.5));
        onlyOrder.setTotalCost(new BigDecimal(2015));

        orderList.put(1001l, onlyOrder);
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        if (order.getOrderId() == onlyOrder.getOrderId()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Map<Long, Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        return orderList;
    }

    @Override
    public Order getOrder(LocalDate orderDate, long orderNum) throws FlooringPersistenceException {
        if (orderNum == onlyOrder.getOrderId()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        if (order.getOrderId() == onlyOrder.getOrderId()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        if (order.getOrderId() == onlyOrder.getOrderId()) {
            return onlyOrder;
        } else {
            return null;
        }
    }
}
