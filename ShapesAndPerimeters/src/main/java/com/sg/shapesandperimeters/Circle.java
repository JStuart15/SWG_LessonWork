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
public class Circle extends Shape {

    private double area;
    private double perimeter;

    public Circle(double radius){
        area = Math.PI * Math.pow(radius, 2);
        perimeter = 2 * Math.PI * radius;
    }
    //getters and setters
    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

}
