/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public interface OrderServicer {

    List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException;

    public Map<String, BigDecimal> getAllStates() throws FlooringPersistenceException;

    public Map<Integer, Product> getAllProducts() throws FlooringPersistenceException;

    public boolean addOrder(Order order) throws OrderValidationException, FlooringPersistenceException;

    public boolean editOrder(Order order) throws OrderValidationException, FlooringPersistenceException;

    public Order removeOrder(LocalDate date, long orderNumber) throws OrderValidationException, FlooringPersistenceException;

    public long getNextOrderNumberForToday() throws FlooringPersistenceException;

    public Order getOrder(LocalDate orderDate, long orderNum) throws FlooringPersistenceException;

    public Boolean saveCurrentWork() throws FlooringPersistenceException;

    public Boolean hasOrdersOnDate(LocalDate date) throws FlooringPersistenceException;

    public boolean hasAnOrderOnDate(long orderNum, LocalDate orderDate) throws FlooringPersistenceException;

    public List<Order> getTransactions();
    
    public void clearTransactions();
    
}
