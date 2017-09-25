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
public class Triangle extends Shape {

    private double area;
    private double perimeter;

    public Triangle(double width, double height){
        area = 0.5 * width * height;
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
