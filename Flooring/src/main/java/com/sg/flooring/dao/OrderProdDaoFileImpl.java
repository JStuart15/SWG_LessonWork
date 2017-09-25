/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author jstuart15
 */
public class OrderProdDaoFileImpl implements OrderDao {

    public static final String DELIMETER = "||";
    private Map<Long, Order> orders = new HashMap<>();
    private static final String ordersDirectory = "./flooringFiles/";

    private void createDirectory() {
        File newDir = new File("./", "flooringFiles");
        newDir.mkdir();
    }

    private void writeOrders(LocalDate date) throws FlooringPersistenceException {
        //@todo - low - implement a header row in the file
        createDirectory();
        PrintWriter out;
        String ordersFileName = "Orders_"
                + date.format(DateTimeFormatter.ofPattern("MMddyyyy"))
                + ".txt";
        try {
            File newFile = new File(ordersDirectory, ordersFileName); //create the blank file if it doesn't already exist
            newFile.createNewFile();
            out = new PrintWriter(new FileWriter(ordersDirectory + ordersFileName));
        } catch (IOException e) {
            throw new FlooringPersistenceException("-_-Could not save order data.", e);
        }
        Map<Long, Order> orders = this.getAllOrders(date);
        List<Order> orderList = orders.values().stream().collect(Collectors.toList());
        for (Order order : orderList) {
            //write the order object to the file
            out.println(order.getOrderId() + DELIMETER
                    + order.getCustName().toUpperCase() + DELIMETER
                    + order.getState().toUpperCase() + DELIMETER
                    + order.getTaxRate() + DELIMETER
                    + order.getProductId() + DELIMETER
                    + order.getProductName().toUpperCase() + DELIMETER
                    + order.getArea() + DELIMETER
                    + order.getMaterialCostPsf() + DELIMETER
                    + order.getLaborCostPsf() + DELIMETER
                    + order.getMaterialCost() + DELIMETER
                    + order.getLaborCost() + DELIMETER
                    + order.getTax() + DELIMETER
                    + order.getTotalCost() + DELIMETER
                    + order.getOrderDate());
            //force PrintWriter to write all to the file
            out.flush();
        }
        //clean up
        out.close();
    }

    private void loadOrders(LocalDate date) throws FlooringPersistenceException {
        Scanner scanner;
        String ordersFileName = "Orders_"
                + date.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
        createDirectory();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ordersDirectory + ordersFileName)));
        } catch (IOException e) {
            throw new FlooringPersistenceException("-_- Could not load order information into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            Order currentOrder = new Order(Long.parseLong(currentTokens[0]));
            currentOrder.setCustName(currentTokens[1].toUpperCase());
            currentOrder.setState(currentTokens[2].toUpperCase());
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductId(Integer.parseInt(currentTokens[4]));
            currentOrder.setProductName(currentTokens[5].toUpperCase());
            currentOrder.setArea(Double.parseDouble(currentTokens[6]));
            currentOrder.setMaterialCostPsf(new BigDecimal(currentTokens[7]));
            currentOrder.setLaborCostPsf(new BigDecimal(currentTokens[8]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[9]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[10]));
            currentOrder.setTax(new BigDecimal(currentTokens[11]));
            currentOrder.setTotalCost(new BigDecimal(currentTokens[12]));
            currentOrder.setOrderDate(LocalDate.parse(currentTokens[13]));

            orders.put(currentOrder.getOrderId(), currentOrder);
        }
        scanner.close();
    }

    @Override
    public Map<Long, Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        loadOrders(date);
        return orders;
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        try {//try to add along with orders from files
            loadOrders(order.getOrderDate());
            orders.put(order.getOrderId(), order);
            writeOrders(order.getOrderDate());
            return order;
        } catch (Exception e) {//another attempt if no orders in files
            //Order newOrder = order;
            orders.put(order.getOrderId(), order);
            writeOrders(order.getOrderDate());
            return order;
        }
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        try {//try to load orders for a date, if not there then there are
            //no perisisted order to act upon
            loadOrders(order.getOrderDate());
            orders.remove(order.getOrderId());
            Order editedOrder = orders.put(order.getOrderId(), order);
            writeOrders(order.getOrderDate());
            return editedOrder;
        } catch (Exception e) {
            orders.remove(order.getOrderId());
            Order editedOrder = orders.put(order.getOrderId(), order);
            writeOrders(order.getOrderDate());
            return editedOrder;
        }

    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        try {//try to load from file, if not successful, there was no persisted
            //order to act upon
            loadOrders(order.getOrderDate());
            Order removedOrder = orders.remove(order.getOrderId());
            writeOrders(order.getOrderDate());
            return removedOrder;
        } catch (Exception e) {
            return order;
        }
    }

    @Override
    public Order getOrder(LocalDate orderDate, long orderNum) throws FlooringPersistenceException {
        loadOrders(orderDate);
        return orders.get(orderNum);
    }

    //WORK IN PROGRESS
//    private void writeOrdersCSV(LocalDate date) throws FlooringPersistenceException {
//        CSVWriter writer;
//        Map<Long, Order> orderList = this.getAllOrders(date);
//        String ordersFileName = "Orders_"
//                + date.format(DateTimeFormatter.ofPattern("MMddyyyy"))
//                + ".txt";
//        try {
//            writer = new CSVWriter(new FileWriter(ordersFileName), ',');
//        } catch (Exception e) {
//            throw new FlooringPersistenceException("-_-Could not save order data as CSV.", e);
//        }
//        String[] entries = new String[13];
//        for (int i = 0; i < entries.length; i++) {
//            for (int j = 0; j < orderList.size(); j++) {
//                entries[i]
//                        = orderList.get(j).getOrderId() + CSVDELIMETER
//                        + orderList.get(j).getCustName().toUpperCase() + CSVDELIMETER
//                        + orderList.get(j).getState().toUpperCase() + CSVDELIMETER
//                        + orderList.get(j).getTaxRate() + CSVDELIMETER
//                        + orderList.get(j).getProductId() + CSVDELIMETER
//                        + orderList.get(j).getProductName().toUpperCase() + CSVDELIMETER
//                        + orderList.get(j).getArea() + CSVDELIMETER
//                        + orderList.get(j).getMaterialCostPsf() + CSVDELIMETER
//                        + orderList.get(j).getLaborCostPsf() + CSVDELIMETER
//                        + orderList.get(j).getMaterialCost() + CSVDELIMETER
//                        + orderList.get(j).getLaborCost() + CSVDELIMETER
//                        + orderList.get(j).getTax() + CSVDELIMETER
//                        + orderList.get(j).getTotalCost() + CSVDELIMETER
//                        + orderList.get(j).getOrderDate();
//            }
//            writer.writeNext(entries);
//            try {
//                writer.flush();
//
//            } catch (IOException ex) {
//                Logger.getLogger(OrderProdDaoFileImpl.class
//                        .getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        try {
//            writer.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(OrderProdDaoFileImpl.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private void loadOrdersCSV(LocalDate date) throws FlooringPersistenceException {
//        CSVReader reader;
//        String ordersFileName = "Orders_"
//                + date.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
//        try {
//            reader = new CSVReader(
//                    new FileReader(ordersDirectory + ordersFileName), ',', '"'); //, '"',2 can add header file if needed
//        } catch (IOException e) {
//            throw new FlooringPersistenceException("-_- Could not load order information into memory.", e);
//        }
//        String[] nextLine;
//        String[] currentToken;
//        try {
//            ;
//            while ((nextLine = reader.readNext()) != null) {
//                if (nextLine != null) {
//                    Order currentOrder = new Order(Long.parseLong(nextLine[0]));
//                    currentOrder.setCustName(nextLine[1]);
//                    currentOrder.setState(nextLine[2]);
//                    currentOrder.setTaxRate(new BigDecimal(nextLine[3]));
//                    currentOrder.setProductId(Integer.parseInt(nextLine[4]));
//                    currentOrder.setProductName(nextLine[5].toUpperCase());
//                    currentOrder.setArea(Double.parseDouble(nextLine[6]));
//                    currentOrder.setMaterialCostPsf(new BigDecimal(nextLine[7]));
//                    currentOrder.setLaborCostPsf(new BigDecimal(nextLine[8]));
//                    currentOrder.setMaterialCost(new BigDecimal(nextLine[9]));
//                    currentOrder.setLaborCost(new BigDecimal(nextLine[10]));
//                    currentOrder.setTax(new BigDecimal(nextLine[11]));
//                    currentOrder.setTotalCost(new BigDecimal(nextLine[12]));
//                    currentOrder.setOrderDate(LocalDate.parse(nextLine[13]));
//
//                    orders.put(currentOrder.getOrderId(), currentOrder);
//                }
//                reader.close();
//            }
//        } catch (IOException ex) {
//            throw new FlooringPersistenceException("-_- Could not load order information into memory.", ex);
//        }
//    }
}
