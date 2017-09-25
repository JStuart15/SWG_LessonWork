/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

/**
 *
 * @author jstuart15
 */
public class House2 {

    private int squareFootage;
    private float kitchenWidth;
    private float kitchenLength;
    private int numberOfFloors;
    private float numberOfBaths;
    private int numberOfBedrooms;

    public House2(){
        
    }
    
    public House2(int squareFootage, float kitchenWidth,
            float kitchenLength, int numberOfFloors,
            float numberOfBaths, int numberOfBedrooms) {
        this.squareFootage = squareFootage;
        this.kitchenWidth = kitchenWidth;
        this.kitchenLength = kitchenLength;
        this.numberOfFloors = numberOfFloors;
        this.numberOfBaths = numberOfBaths;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public float calculateSquareFootage(){
        return 0;
    }
    
    //setters and getters
    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public float getKitchenWidth() {
        return kitchenWidth;
    }

    public void setKitchenWidth(float kitchenWidth) {
        this.kitchenWidth = kitchenWidth;
    }

    public float getKitchenLength() {
        return kitchenLength;
    }

    public void setKitchenLength(float kitchenLength) {
        this.kitchenLength = kitchenLength;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public float getNumberOfBaths() {
        return numberOfBaths;
    }

    public void setNumberOfBaths(float numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

}
