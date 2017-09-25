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
public class School1 {
    private String name;
    private String description;
    private int numberOfClassrooms;
    private double squareFootage;
    private int studentCapacity;
    private Cafeteria cafeteria;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the numberOfClassrooms
     */
    public int getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    /**
     * @param numberOfClassrooms the numberOfClassrooms to set
     */
    public void setNumberOfClassrooms(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
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
     * @return the studentCapacity
     */
    public int getStudentCapacity() {
        return studentCapacity;
    }

    /**
     * @param studentCapacity the studentCapacity to set
     */
    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    /**
     * @return the cafeteria
     */
    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    /**
     * @param cafeteria the cafeteria to set
     */
    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }
    
    
}
