/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;

/**
 *
 * @author jstuart15
 */
public class OrderTrainingDaoFileImpl extends OrderProdDaoFileImpl {

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        //do nothing in training mode
        return null;
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        //do nothing in training mode
        return null;
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        //do nothing in training mode
        return null;
    }
}
