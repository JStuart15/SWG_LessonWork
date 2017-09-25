/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public interface OrderDao {
    
    Map<Long, Order> getAllOrders(LocalDate date) throws FlooringPersistenceException;
    
    Order addOrder(Order order) throws FlooringPersistenceException;
    
    Order editOrder(Order order) throws FlooringPersistenceException;
    
    Order removeOrder(Order order) throws FlooringPersistenceException;

    public Order getOrder(LocalDate orderDate, long orderNum)  throws FlooringPersistenceException;
}
