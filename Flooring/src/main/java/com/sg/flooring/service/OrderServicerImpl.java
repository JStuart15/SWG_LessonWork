/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dao.OrderDao;
import com.sg.flooring.dao.ProductDao;
import com.sg.flooring.dao.StateDao;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author jstuart15
 */
public class OrderServicerImpl implements OrderServicer {

    private OrderDao orderDao;
    private ProductDao productDao;
    private StateDao stateDao;
    private Queue<Order> transactions = new LinkedList<>();

    //constructor
    public OrderServicerImpl(OrderDao orderDao, ProductDao productDao, StateDao stateDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.stateDao = stateDao;
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        Map<Long, Order> orders = new HashMap<>();
        try {//get orders from the file
            Map<Long, Order> ordersFromDao = orderDao.getAllOrders(date);
            List<Order> ordersFromDaoList = ordersFromDao.values().stream().collect(Collectors.toList());

            for (Order o : ordersFromDaoList) {
                orders.put(o.getOrderId(), o);
            }
        } catch (FlooringPersistenceException e) {
            //do nothing in this case because there are no orders in the file and/or no file
        }
        //Add transactions to the orders from the files
        for (Order t : transactions) {
            orders.put(t.getOrderId(), t);
        }
        //Remove the orders with "remove" as a next action
        return orders
                .values()
                .stream()
                .filter(o -> o.getNextAction() != "remove")
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, BigDecimal> getAllStates() throws FlooringPersistenceException {
        return stateDao.getAllStates();
    }

    @Override
    public Map<Integer, Product> getAllProducts() throws FlooringPersistenceException {
        return productDao.getAllProducts();
    }

    private boolean validateOrder(Order currentOrder) throws OrderValidationException, FlooringPersistenceException {
        boolean hasValidState = this.validateState(currentOrder);
        boolean hasValidArea = this.validateArea(currentOrder);
        boolean hasValidProduct = this.validateProduct(currentOrder);
        boolean hasValidCustName = this.validateCustomerName(currentOrder);
        if (hasValidState
                && hasValidArea
                && hasValidProduct
                && hasValidCustName) {
            return true;
        }
        return false;
    }

    private boolean validateState(Order currentOrder) throws OrderValidationException, FlooringPersistenceException {
        Set<String> stateValues = stateDao.getAllStates().keySet();
        if (stateValues.contains(currentOrder.getState().toUpperCase())) {
            return true;
        } else {
            currentOrder.setError("Customer State not found.");
        }
        return false;
    }

    private boolean validateArea(Order currentOrder) throws OrderValidationException, FlooringPersistenceException {
        if (currentOrder.getArea() > 0) {
            return true;
        } else {
            currentOrder.setError("Area is less than or equal to 0");
        }
        return false;
    }

    private boolean validateProduct(Order currentOrder) throws FlooringPersistenceException {
        Map<Integer, Product> products = productDao.getAllProducts();
        if (products.containsKey(currentOrder.getProductId())) {
            return true;
        } else {
            currentOrder.setError("Product does not exist");
            return false;
        }
    }

    private boolean validateCustomerName(Order currentOrder) {
        if (currentOrder.getCustName().isEmpty()) {
            currentOrder.setError("Customer name can't be blank");
            return false;
        } else {
            return true;
        }
    }

    private boolean calculateOrderValues(Order order) throws FlooringPersistenceException {
        Map<String, BigDecimal> stateList = stateDao.getAllStates();
        Map<Integer, Product> productList = productDao.getAllProducts();
        Product newProd = productList.get(order.getProductId());

        order.setLaborCostPsf(newProd.getLaborCostPsf());
        order.setMaterialCostPsf(newProd.getMatCostPsf());

        BigDecimal materialCost = order
                .getMaterialCostPsf()
                .multiply(new BigDecimal(order.getArea()))
                .setScale(2, RoundingMode.HALF_UP);
        order.setMaterialCost(materialCost);

        BigDecimal laborCost = order
                .getLaborCostPsf()
                .multiply(new BigDecimal(order.getArea()))
                .setScale(2, RoundingMode.HALF_UP);
        order.setLaborCost(laborCost);

        BigDecimal subTotal = laborCost.add(materialCost);

        order.setTaxRate(stateList.get(order.getState()));
        BigDecimal taxes = subTotal.multiply(order
                .getTaxRate()
                .divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_UP);
        order.setTax(taxes);

        BigDecimal totalCost = laborCost.add(materialCost)
                .add(taxes)
                .setScale(2, RoundingMode.HALF_UP);
        order.setTotalCost(totalCost);

        if (order.getTotalCost() == null
                || order.getTotalCost().compareTo(new BigDecimal(0)) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public long getNextOrderNumberForToday() throws FlooringPersistenceException {
        try {
            Map<Long, Order> orders = orderDao.getAllOrders(LocalDate.now());
            return 1 + orders.values().stream()
                    .map(o -> o.getOrderId())
                    .max(Comparator.naturalOrder())
                    .orElse((long) 0);
        } catch (Exception e) {
            return (long) 1;
        }

    }

    @Override
    public Order getOrder(LocalDate orderDate, long orderNum) throws FlooringPersistenceException {
        //Items in the transaction stack need to be returned preferentially 
        //because files won't have unsaved work in the transaction queue
        Order order;
        for (Order t : transactions) {
            if (t.getOrderId() == orderNum && t.getOrderDate().equals(orderDate)) {
                order = t;
                return order;
            }
        }
        return orderDao.getOrder(orderDate, orderNum);
    }

    @Override
    public Boolean saveCurrentWork() throws FlooringPersistenceException {
        try {
            for (Order order : transactions) {
                String nextAction = order.getNextAction();
                switch (nextAction) {
                    case "add":
                        orderDao.addOrder(order);
                        break;
                    case "edit":
                        orderDao.editOrder(order);
                        break;
                    case "remove":
                        orderDao.removeOrder(order);
                        break;
                }
            }
            return true;
        } catch (FlooringPersistenceException e) {
            return false;
        }
    }

    @Override
    public Boolean hasOrdersOnDate(LocalDate date) throws FlooringPersistenceException {
        if (this.getAllOrders(date).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasAnOrderOnDate(long orderNum, LocalDate orderDate) throws FlooringPersistenceException {
        List<Long> allOrders = this.getAllOrders(orderDate)
                .stream()
                .map(o -> o.getOrderId())
                .collect(Collectors.toList());
        if (allOrders.contains(orderNum)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addOrder(Order order) throws OrderValidationException, FlooringPersistenceException {
        if (this.validateOrder(order) && this.calculateOrderValues(order)) {
            order.setNextAction("add");
            order.setOrderDate(LocalDate.now());
            transactions.add(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editOrder(Order order) throws OrderValidationException, FlooringPersistenceException {
        if (this.validateOrder(order) && this.calculateOrderValues(order)) {
            order.setNextAction("edit");
            transactions.add(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Order removeOrder(LocalDate date, long orderNumber) throws OrderValidationException, FlooringPersistenceException {
        try {//attempt with file information
            Order orderToRemove = this.getOrder(date, orderNumber);
            orderToRemove.setNextAction("remove");
            orderToRemove.setOrderDate(date);
            transactions.add(orderToRemove);
            return orderToRemove;
        } catch (Exception e) {
            try {//attempt with transaction stack if none in file
                Order orderToRemove = null;
                for (Order t : transactions) {
                    if (t.getOrderId() == orderNumber && t.getOrderDate() == date) {
                        orderToRemove = t;
                        orderToRemove.setNextAction("remove");
                        transactions.add(orderToRemove);
                    }
                    return orderToRemove;
                }
            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Order> getTransactions() {
        return transactions.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void clearTransactions() {
        transactions.clear();
    }
}
