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
public class Cafeteria {
    private int numberOfStoves;
    private int seatingCapacity;
    private double squareFootage;
    private int numberOfServingLines;
    private int mealsPerHour; 

    /**
     * @return the numberOfStoves
     */
    public int getNumberOfStoves() {
        return numberOfStoves;
    }

    /**
     * @param numberOfStoves the numberOfStoves to set
     */
    public void setNumberOfStoves(int numberOfStoves) {
        this.numberOfStoves = numberOfStoves;
    }

    /**
     * @return the seatingCapacity
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * @param seatingCapacity the seatingCapacity to set
     */
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * @return the squareFootage
     */
    public double getSquareFootage() {
        return squareFootage;
    }

    /**
     * @param squareFootage the squareFootage to set
     */
    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    /**
     * @return the numberOfServingLines
     */
    public int getNumberOfServingLines() {
        return numberOfServingLines;
    }

    /**
     * @param numberOfServingLines the numberOfServingLines to set
     */
    public void setNumberOfServingLines(int numberOfServingLines) {
        this.numberOfServingLines = numberOfServingLines;
    }

    /**
     * @return the mealsPerHour
     */
    public int getMealsPerHour() {
        return mealsPerHour;
    }

    /**
     * @param mealsPerHour the mealsPerHour to set
     */
    public void setMealsPerHour(int mealsPerHour) {
        this.mealsPerHour = mealsPerHour;
    }
}
