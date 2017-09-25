/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

/**
 *
 * @author jstuart15
 */
public abstract class Shape {
    private String color = "Blue";
    
    public abstract double getArea();//no {} brackets!
    public abstract double getPerimeter();
}
