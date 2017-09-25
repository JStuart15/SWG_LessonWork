/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practiceprogramming2;

/**
 *
 * @author jstuart15
 */
public class MoreBucketsMoreFun {
    public static void main(String[] args) {
        // declare all the things
        // usually its a good idea to declare them at the beginning of the program
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number;
        
        // now give a couple of them some values
        butterflies = 2;
        beetles = 4;
        
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies");
        System.out.println("but " + bugs + " bugs total.");
        
        System.out.println("Uh oh, my dog ate one.");
        butterflies--; //using the unary decrement operator to reduce butterflies by one
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time..."); //we need to do another assignment of bugs
        
        bugs = butterflies + beetles;
        System.out.println("Now that we fixed our code,there are " + butterflies + " butterflies, and " + bugs + " bugs");
    }
}
