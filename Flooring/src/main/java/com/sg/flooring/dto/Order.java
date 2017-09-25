/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author jstuart15
 */
public class Order {

    private long orderId;
    private String custName;
    private String state;
    private BigDecimal taxRate;
    private int productId;
    private String productName;
    private double area;
    private BigDecimal materialCostPsf;
    private BigDecimal laborCostPsf;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal totalCost;
    private Stack<String> errors = new Stack<>();
    private String nextAction;
    private LocalDate orderDate;

    //constructor
    public Order(long orderId) {
        this.orderId = orderId;
    }

    //getters and setters
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public BigDecimal getMaterialCostPsf() {
        return materialCostPsf;
    }

    public void setMaterialCostPsf(BigDecimal materialCostPsf) {
        this.materialCostPsf = materialCostPsf;
    }

    public BigDecimal getLaborCostPsf() {
        return laborCostPsf;
    }

    public void setLaborCostPsf(BigDecimal laborCostPsf) {
        this.laborCostPsf = laborCostPsf;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Stack<String> getErrors() {
        return errors;
    }

    public void setError(String error) {
        this.errors.push(error);
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.orderId ^ (this.orderId >>> 32));
        hash = 53 * hash + Objects.hashCode(this.custName);
        hash = 53 * hash + Objects.hashCode(this.state);
        hash = 53 * hash + Objects.hashCode(this.taxRate);
        hash = 53 * hash + this.productId;
        hash = 53 * hash + Objects.hashCode(this.productName);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.area) ^ (Double.doubleToLongBits(this.area) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.materialCostPsf);
        hash = 53 * hash + Objects.hashCode(this.laborCostPsf);
        hash = 53 * hash + Objects.hashCode(this.materialCost);
        hash = 53 * hash + Objects.hashCode(this.laborCost);
        hash = 53 * hash + Objects.hashCode(this.tax);
        hash = 53 * hash + Objects.hashCode(this.totalCost);
        hash = 53 * hash + Objects.hashCode(this.errors);
        hash = 53 * hash + Objects.hashCode(this.nextAction);
        hash = 53 * hash + Objects.hashCode(this.orderDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (!Objects.equals(this.custName, other.custName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.nextAction, other.nextAction)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.materialCostPsf, other.materialCostPsf)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPsf, other.laborCostPsf)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.totalCost, other.totalCost)) {
            return false;
        }
        if (!Objects.equals(this.errors, other.errors)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", custName=" + custName + ", state=" + state + ", taxRate=" + taxRate + ", productId=" + productId + ", productName=" + productName + ", area=" + area + ", materialCostPsf=" + materialCostPsf + ", laborCostPsf=" + laborCostPsf + ", materialCost=" + materialCost + ", laborCost=" + laborCost + ", tax=" + tax + ", totalCost=" + totalCost + ", errors=" + errors + ", nextAction=" + nextAction + ", orderDate=" + orderDate + '}';
    }
}
