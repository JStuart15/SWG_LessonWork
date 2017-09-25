/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.dto;

/**
 *
 * @author jstuart15
 */
public class Item {
    private String itemNumber;
    private String name;
    private String description;
    private String cost;
    private String locationInHouse;
    private String manufacturer;
    
    
    //constructor
    public Item(String itemNumber){
        this.itemNumber = itemNumber;
    }
    //getters and setters
    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLocationInHouse() {
        return locationInHouse;
    }

    public void setLocationInHouse(String locationInHouse) {
        this.locationInHouse = locationInHouse;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    
    
}
