/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

/**
 *
 * @author jstuart15
 */
public class WaitAWhile {
    public static void main(String[] args) {
        int timeNow = 11;
        int bedTime = 10;
        
        while (timeNow < bedTime){
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer...");
            timeNow++; // without this we would loop indefinitely
        }
        
        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed...");
    }
}
