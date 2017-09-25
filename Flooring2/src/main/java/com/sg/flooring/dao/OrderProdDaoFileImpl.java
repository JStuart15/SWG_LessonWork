/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sg.flooring.dto.Order;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author jstuart15
 */
public class OrderProdDaoFileImpl implements OrderDao {

    private Map<Long, Order> orders = new HashMap<>();
    private static final String ORDERS_DIRECTORY = "./flooringFiles/";

    private void createDirectory() {
        File newDir = new File("./", "flooringFiles");
        newDir.mkdir();
    }

    @Override
    public Map<Long, Order> getAllOrders(LocalDate date)
            throws FlooringPersistenceException {
        loadOrdersCSV(date);
        return orders;
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        try {//try to add along with orders from files
            loadOrdersCSV(order.getOrderDate());
            orders.put(order.getOrderId(), order);
            writeOrdersCSV(order.getOrderDate());
            return order;
        } catch (Exception e) {//another attempt if no orders in files
            //Order newOrder = order;
            orders.put(order.getOrderId(), order);
            writeOrdersCSV(order.getOrderDate());
            return order;
        }
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        try {//try to load orders for a date, if not there then there are
            //no perisisted order to act upon
            loadOrdersCSV(order.getOrderDate());
            orders.remove(order.getOrderId());
            Order editedOrder = orders.put(order.getOrderId(), order);
            writeOrdersCSV(order.getOrderDate());
            return editedOrder;
        } catch (Exception e) {
            orders.remove(order.getOrderId());
            Order editedOrder = orders.put(order.getOrderId(), order);
            writeOrdersCSV(order.getOrderDate());
            return editedOrder;
        }

    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        try {//try to load from file, if not successful, there was no persisted
            //order to act upon
            loadOrdersCSV(order.getOrderDate());
            Order removedOrder = orders.remove(order.getOrderId());
            writeOrdersCSV(order.getOrderDate());
            return removedOrder;
        } catch (Exception e) {
            return order;
        }
    }

    @Override
    public Order getOrder(LocalDate orderDate, long orderNum)
            throws FlooringPersistenceException {
        loadOrdersCSV(orderDate);
        return orders.get(orderNum);
    }

    private void writeOrdersCSV(LocalDate date)
            throws FlooringPersistenceException {
        createDirectory();
        CSVWriter writer;

        String ordersFileName = "Orders_"
                + date.format(DateTimeFormatter.ofPattern("MMddyyyy"))
                + ".txt";
        try {
            File newFile = new File(ORDERS_DIRECTORY, ordersFileName); //create the blank file if it doesn't already exist
            newFile.createNewFile();
            writer = new CSVWriter(new FileWriter(ORDERS_DIRECTORY + ordersFileName), ',');
        } catch (Exception e) {
            throw new FlooringPersistenceException("-_-Could not create CSV order file.", e);
        }

        Map<Long, Order> orders = this.getAllOrders(date);
        List<Order> orderList = orders.values()
                .stream()
                .collect(Collectors
                        .toList());
        String[] entries = new String[14];
        for (Order order : orderList) {
            entries[0] = Long.toString(order.getOrderId());
            entries[1] = order.getCustName();
            entries[2] = order.getState();
            entries[3] = order.getTaxRate().toString();
            entries[4] = Integer.toString(order.getProductId());
            entries[5] = order.getProductName();
            entries[6] = Double.toString(order.getArea());
            entries[7] = order.getMaterialCostPsf().toString();
            entries[8] = order.getLaborCostPsf().toString();
            entries[9] = order.getMaterialCost().toString();
            entries[10] = order.getLaborCost().toString();
            entries[11] = order.getTax().toString();
            entries[12] = order.getTotalCost().toString();
            entries[13] = order.getOrderDate().toString();
            writer.writeNext(entries);
            try {
                writer.flush();
            } catch (IOException ex) {
                throw new FlooringPersistenceException("-_-Could not flush the CSV order file.", ex);
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            throw new FlooringPersistenceException("-_-Could not close the CSV order file.", ex);
        }
    }

    private void loadOrdersCSV(LocalDate date)
            throws FlooringPersistenceException {
        CSVReader reader;
        String ordersFileName = "Orders_"
                + date.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
        createDirectory();
        try {
            reader = new CSVReader(new FileReader(ORDERS_DIRECTORY + ordersFileName), ',');
        } catch (IOException e) {
            throw new FlooringPersistenceException("-_- Could not find the orders CSV.", e);
        }
        String[] nextLine;
        try {
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    Order currentOrder = new Order(Long.parseLong(nextLine[0]));
                    currentOrder.setCustName(nextLine[1]);
                    currentOrder.setState(nextLine[2]);
                    currentOrder.setTaxRate(new BigDecimal(nextLine[3]));
                    currentOrder.setProductId(Integer.parseInt(nextLine[4]));
                    currentOrder.setProductName(nextLine[5]);
                    currentOrder.setArea(Double.parseDouble(nextLine[6]));
                    currentOrder.setMaterialCostPsf(new BigDecimal(nextLine[7]));
                    currentOrder.setLaborCostPsf(new BigDecimal(nextLine[8]));
                    currentOrder.setMaterialCost(new BigDecimal(nextLine[9]));
                    currentOrder.setLaborCost(new BigDecimal(nextLine[10]));
                    currentOrder.setTax(new BigDecimal(nextLine[11]));
                    currentOrder.setTotalCost(new BigDecimal(nextLine[12]));
                    currentOrder.setOrderDate(LocalDate.parse(nextLine[13]));

                    orders.put(currentOrder.getOrderId(), currentOrder);
                }    
            }
            reader.close();
        } catch (IOException ex) {
            throw new FlooringPersistenceException("-_- Could not load order information into memory.", ex);
        }
    }
}
