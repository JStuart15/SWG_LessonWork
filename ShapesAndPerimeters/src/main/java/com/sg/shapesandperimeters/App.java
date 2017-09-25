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
public class App {
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4.5, 6.7);
        Shape circle = new Circle(1);
        System.out.println("Area of Square " + square.getArea());
        System.out.println("Perimeter of Square " + square.getPerimeter());
        System.out.println("Area of Rectangle " + rectangle.getArea());
        System.out.println("Perimeter of Rectangle " + rectangle.getPerimeter());
        System.out.println("Area of Circle " + circle.getArea());
        System.out.println("Circumference of Circle " + circle.getPerimeter());
    }
}
