/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.controller;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.service.OrderServicer;
import com.sg.flooring.service.OrderValidationException;
import com.sg.flooring.ui.FlooringUserIOException;
import com.sg.flooring.ui.View;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class Controller {

    private View view;
    private OrderServicer service;

    public Controller(OrderServicer service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        int menuSelection;
        try {
            Map<Integer, Product> productList = service.getAllProducts();
            long nextOrderNum = service.getNextOrderNumberForToday();
            do {
                menuSelection = view.displayAndGetMainMenuSelection();
                switch (menuSelection) {
                    case 1://display orders
                        displayOrders();
                        break;

                    case 2://add an order
                        addOrder(productList, nextOrderNum);
                        nextOrderNum++;
                        break;

                    case 3://edit an order
                        editOrder(productList);
                        break;

                    case 4://remove an order
                        removeOrder();
                        break;

                    case 5://save current work
                        saveCurrentWork();
                        break;

                    case 6://exit
                        exit();
                        break;
                }
            } while (menuSelection != 6);
        } catch (FlooringUserIOException
                | FlooringPersistenceException
                | OrderValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void displayOrders() throws FlooringPersistenceException {
        view.displayAllOrdersBanner();
        LocalDate date = view.displayAndGetDate();
        if (service.hasOrdersOnDate(date)) {
            List<Order> orders = service.getAllOrders(date);
            view.displayOrders(orders);
        } else {
            view.displayErrorMessage("There are no orders for that date.");
        }
    }

    private void addOrder(Map<Integer, Product> productList, long nextOrderNum)
            throws FlooringPersistenceException,
            FlooringUserIOException,
            OrderValidationException {
        boolean keepGoing;
        Order orderToAdd;
        List<Order> ordersToAdd = new ArrayList<>();
        do {
            view.displayAddOrderBanner();
            orderToAdd = new Order(nextOrderNum);
            view.displayAndGetOrderAddInformation(productList, orderToAdd);
            if (service.addOrder(orderToAdd)) {
                view.displayOrderAddedBanner();
                ordersToAdd.add(orderToAdd);
                view.displayOrders(ordersToAdd);
                keepGoing = false;
            } else {
                view.displayOrderErrors(orderToAdd);
                orderToAdd.getErrors().clear();
                keepGoing = true;
            }
        } while (keepGoing);
    }

    private void editOrder(Map<Integer, Product> productList)
            throws FlooringPersistenceException, FlooringUserIOException,
            OrderValidationException {
        List<Order> ordersToEdit = new ArrayList<>();
        Order orderToEdit;
        Boolean keepGoing;
        view.displayEditOrderBanner();
        LocalDate orderDate = view.displayAndGetDate();
        if (service.hasOrdersOnDate(orderDate)) {
            long orderNum = view.displayAndGetOrderNum();
            if (service.hasAnOrderOnDate(orderNum, orderDate)) {
                orderToEdit = service.getOrder(orderDate, orderNum);
                do {
                    orderToEdit = view.displayAndGetOrderEditInformation(orderToEdit, productList);
                    if (service.editOrder(orderToEdit)) {
                        view.displayOrderEditedBanner();
                        ordersToEdit.add(orderToEdit);
                        view.displayOrders(ordersToEdit);
                        keepGoing = false;
                    } else {
                        view.displayOrderErrors(orderToEdit);
                        orderToEdit.getErrors().clear();
                        view.displayEditOrderBanner();
                        keepGoing = true;
                    }
                } while (keepGoing);
            } else {
                view.displayErrorMessage("That order doesn't exist on that date.");
            }
        } else {
            view.displayErrorMessage("There are no orders entered on that date.");
        }
    }

    private void removeOrder() throws FlooringPersistenceException, OrderValidationException {
        LocalDate orderDate = view.displayAndGetDate();
        List<Order> ordersToRemove = new ArrayList<>();
        if (service.hasOrdersOnDate(orderDate)) {
            long orderNum = view.displayAndGetOrderNum();
            if (service.hasAnOrderOnDate(orderNum, orderDate)) {
                view.displayOrderRemovedBanner();
                ordersToRemove.add(service.removeOrder(orderDate, orderNum));
                view.displayOrders(ordersToRemove);
            } else {
                view.displayErrorMessage("That order doesn't exist on that date.");
            }
        } else {
            view.displayErrorMessage("There are no orders entered on that date.");
        }
    }

    private void saveCurrentWork()
            throws FlooringPersistenceException {
        view.displaySavedCurrentWorkBanner();
        List<Order> transactions = service.getTransactions();
        view.displayTransactions(transactions);
        if (service.saveCurrentWork()) {
            service.clearTransactions();
        } else {
            view.displayMessage("Not able to save current work, please try again.");
        }
    }

    private void exit() throws FlooringPersistenceException {
        if (service.getTransactions().size() > 0) {
            String isSaveWork = view
                    .displayYesOrNo("WARNING - if you exit now all your work "
                            + "will be lost.  Would you like to save it (y/n)?");
            if (isSaveWork.equalsIgnoreCase("y")) {
                saveCurrentWork();
            }
        }
        view.displayExitBanner();
    }
}
