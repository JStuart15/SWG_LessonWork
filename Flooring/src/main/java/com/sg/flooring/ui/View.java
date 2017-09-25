/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.ui;

import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    //banners
    public void displaySavedCurrentWorkBanner() {
        io.println("=== Save Current Work ===");
    }

    public void displayWelcomeBanner() {
        io.println("=== Welcome to the Flooring Order System ===");
    }

    public void displayAllOrdersBanner() {
        io.println("=== Display All Orders ===");
    }

    public void displayRemoveOrderBanner() {
        io.println("=== Remove Order ===");
    }

    public void displayExitBanner() {
        io.println("=== Good Bye! ===");
    }

    public void displayErrorMessage(String errorMsg) {
        io.println("=== Error ===");
        io.println(errorMsg);
    }

    public void displayOrderAddedBanner() {
        io.println("\n=== Order Added to Current Work ===");
    }

    public void displayOrderRemovedBanner() {
        io.println("\n=== Order Removal Added to Current Work ===");
    }

    public void displayOrderEditedBanner() {
        io.println("\n=== Order Edit Added to Current Work ===");
    }

    //Menu Operations
    public int displayAndGetMainMenuSelection() throws FlooringUserIOException {
        io.println("\nMain Menu"
                + "\n******************************"
                + "\n* 1. Display Orders"
                + "\n* 2. Add an Order"
                + "\n* 3. Edit an Order"
                + "\n* 4. Remove an Order"
                + "\n* 5. Save Current Work"
                + "\n* 6. Quit"
                + "\n******************************");
        return io.readInt("Please select an option: ", 1, 6);
    }

    public Long displayAndGetOrderNum() {
        return io.readLong("Please enter the order number: ");
    }

    public LocalDate displayAndGetDate() {
        LocalDate date;
        Boolean keepGoing = true;
        do {
            String input = io.readString("Please enter the order date (MM/DD/YY): ");
            try {
                date = LocalDate.parse(input, DateTimeFormatter
                        .ofPattern("MM/dd/yy"));
                keepGoing = false;
                return date;

            } catch (Exception e) {
                keepGoing = true;
            }
        } while (keepGoing);
        return null;
    }

    public void displayOrders(List<Order> orders) {
        //todo - medium - sort orders using a stream by natural order
        for (Order order : orders) {
            System.out.println(
                    "****************************************************"
                    + "\n*                     Order Num: " + order.getOrderId()
                    + "\n*                      Customer: " + order.getCustName().toUpperCase()
                    + "\n*                         State: " + order.getState().toUpperCase()
                    + "\n*                      Tax Rate: " + order.getTaxRate() + "%"
                    + "\n*                       Product: " + order.getProductName().toUpperCase()
                    + "\n*                          Area: " + order.getArea() + " sqf"
                    + "\n* Material Cost per Square Foot: $" + order.getMaterialCostPsf()
                    + "\n*    Labor Cost per Square Foot: $" + order.getLaborCostPsf()
                    + "\n*                 Material Cost: $" + order.getMaterialCost()
                    + "\n*                    Labor Cost: $" + order.getLaborCost()
                    + "\n*                           Tax: $" + order.getTax()
                    + "\n*                    Total Cost: $" + order.getTotalCost());
        }
        io.println("****************************************************");
        io.readString("\nPress Enter to Continue");
    }

    public void displayOrderErrors(Order newOrder) {
        for (String error : newOrder.getErrors()) {
            this.displayErrorMessage(error);
        }
        io.println("");
    }

    public void displayOrder(Order newOrder) {
        //@todo - medium - can this be combined with displayOrders?
        System.out.println(
                "****************************************************"
                + "\n*                  Order Number: " + newOrder.getOrderId()
                + "\n*                      Customer: " + newOrder.getCustName().toUpperCase()
                + "\n*                         State: " + newOrder.getState().toUpperCase()
                + "\n*                      Tax Rate: " + newOrder.getTaxRate() + "%"
                + "\n*                       Product: " + newOrder.getProductName().toUpperCase()
                + "\n*                          Area: " + newOrder.getArea() + " sqf"
                + "\n* Material Cost per Square Foot: $" + newOrder.getMaterialCostPsf()
                + "\n*    Labor Cost per Square Foot: $" + newOrder.getLaborCostPsf()
                + "\n*                 Material Cost: $" + newOrder.getMaterialCost()
                + "\n*                    Labor Cost: $" + newOrder.getLaborCost()
                + "\n*                           Tax: $" + newOrder.getTax()
                + "\n*                    Total Cost: $" + newOrder.getTotalCost()
                + "\n****************************************************");
        io.readString("\nPress Enter to Continue");
//        }
    }

    public Order displayAndGetOrderEditInformation(Order orderToEdit, Map<Integer, Product> productList)
            throws FlooringUserIOException {

        String custName = io.readString("Please enter the customer name ("
                + orderToEdit.getCustName() + "): ").toUpperCase();
        if (custName.isEmpty()) {
            orderToEdit.setCustName(orderToEdit.getCustName());
        } else {
            orderToEdit.setCustName(custName);
        }

        String state = io.readString("Please enter the State ("
                + orderToEdit.getState() + "): ").toUpperCase();
        if (state.isEmpty()) {
            orderToEdit.setState(orderToEdit.getState());
        } else {
            orderToEdit.setState(state);
        }

        Product product = this.displayAndGetProductInformation(productList, orderToEdit);
        if (product == null) {
            orderToEdit.setProductId(orderToEdit.getProductId());
            orderToEdit.setProductName(orderToEdit.getProductName());
        } else {
            orderToEdit.setProductId(product.getProductId());
            orderToEdit.setProductName(product.getProductName());
        }

        String area = io.readString("Please enter the Area in square feet ("
                + orderToEdit.getArea() + "): ");
        try {
            orderToEdit.setArea(Double.parseDouble(area));
        } catch (Exception e) {
            orderToEdit.setArea(orderToEdit.getArea());
        }
        return orderToEdit;
    }

    public Order displayAndGetOrderAddInformation(Map<Integer, Product> productList, Order order)
            throws FlooringUserIOException {
        order.setCustName(io.readString("Please enter the customer name: ").toUpperCase());
        order.setState(io.readString("Please enter the State abbreviation (e.g. MN, AZ): ", 2, 2).toUpperCase());
        Product product = this.displayAndGetProductInformationForAdd(productList, order);
        order.setProductName(product.getProductName());
        order.setProductId(product.getProductId());
        order.setArea(io.readDouble("Please enter the Area in square feet: "));
        return order;
    }

    public Product displayAndGetProductInformationForAdd(Map<Integer, Product> productList, Order order)
            throws FlooringUserIOException {
        this.displayProductListBanner();
        productList.values().stream().forEachOrdered(i -> io.println(i.toString()));
        int min = productList.values().stream().map(p -> p.getProductId()).min(Comparator.naturalOrder()).orElse(1);
        int max = productList.values().stream().map(p -> p.getProductId()).max(Comparator.naturalOrder()).orElse(0);
        return productList.get(io.readInt("Please select a product ", min, max));
    }

    public Product displayAndGetProductInformation(Map<Integer, Product> productList, Order order)
            throws FlooringUserIOException {
        String prompt;
        int min = productList.values().stream().map(p -> p.getProductId()).min(Comparator.naturalOrder()).orElse(1);
        int max = productList.values().stream().map(p -> p.getProductId()).max(Comparator.naturalOrder()).orElse(0);
        this.displayProductListBanner();
        productList.values().stream().forEachOrdered(i -> io.println(i.toString()));
        try {
            order.getProductName().isEmpty();
            prompt = "Please select a product (" + order.getProductId()
                    + " - " + order.getProductName() + "):";

        } catch (Exception e) {
            prompt = "Please select a product ";
        }
        return productList.get(io.readIntEdit(prompt, min, max));
    }

    public void displayMessage(String message) {
        io.println(message);
    }

    public String displayYesOrNo(String message) {
        return io.readString(message, 1, 1);
    }

    public void displayTransactions(List<Order> transactions) {
        if (transactions.size() == 0) {
            this.displayMessage("There are no transactions to save.");
        } else {
            this.displayMessage("The following transactions (" + transactions.size() + ") have been saved.");

            for (Order transaction : transactions) {
                this.displayMessage("=== " + transaction.getNextAction().toUpperCase() + " Order ===");
                this.displayOrder(transaction);
            }
        }
    }

    private void displayProductListBanner() {
        io.println("=== Product List ===");
    }

    public void displayAddOrderBanner() {
        io.println("=== Add an Order ===");
    }

    public void displayEditOrderBanner() {
        io.println("=== Edit an Order ===");

    }
}
