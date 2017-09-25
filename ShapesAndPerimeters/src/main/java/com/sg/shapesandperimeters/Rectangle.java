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
public class Rectangle extends Shape {

    private double area;
    private double perimeter;
    
    public Rectangle(double width, double height){
        area = width * height;
        perimeter = 2 * (width + height);
    }
    
    //getters and setters
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

}
