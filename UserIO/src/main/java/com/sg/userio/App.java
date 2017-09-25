/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

/**
 *
 * @author jstuart15
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new ConsoleInput();
        
//        double d = io.readDouble("Enter a double: ");
//        System.out.println(d);
        
        io.readDouble("Enter a double: ", 1, 10);
    }
}
