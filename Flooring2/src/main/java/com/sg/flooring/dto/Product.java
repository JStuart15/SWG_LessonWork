/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author jstuart15
 */
public class Product {

    private int productId;
    private String productName;
    private BigDecimal matCostPsf;
    private BigDecimal laborCostPsf;

    public Product(int productId, String productName, BigDecimal matCostPsf, BigDecimal laborCostPsf) {
        this.productId=productId;
        this.productName = productName;
        this.matCostPsf = matCostPsf;
        this.laborCostPsf = laborCostPsf;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getMatCostPsf() {
        return matCostPsf;
    }

    public void setMatCostPsf(BigDecimal matCostPsf) {
        this.matCostPsf = matCostPsf;
    }

    public BigDecimal getLaborCostPsf() {
        return laborCostPsf;
    }

    public void setLaborCostPsf(BigDecimal laborCostPsf) {
        this.laborCostPsf = laborCostPsf;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return productId + " - " + productName;
    }

}
