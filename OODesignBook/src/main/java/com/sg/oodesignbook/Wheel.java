/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.oodesignbook;

/**
 *
 * @author jstuart15
 */
public class Wheel {
    private int rimDiameter;
    private int tireDiameter;
    
    //Constructor
    public Wheel(int rimDiameter, int tireDiameter) {    
        this.rimDiameter = rimDiameter;
        this.tireDiameter = tireDiameter;
    }

    //getters and setters
    public int getRimDiameter() {
        return rimDiameter;
    }

    public void setRimDiameter(int rimDiameter) {
        this.rimDiameter = rimDiameter;
    }

    public int getTireDiameter() {
        return tireDiameter;
    }

    public void setTireDiameter(int tireDiameter) {
        this.tireDiameter = tireDiameter;
    }
    
    //Methods
    public double getWheelDiameter(){
        return (double)rimDiameter + (double)(tireDiameter*2);
    }
}
