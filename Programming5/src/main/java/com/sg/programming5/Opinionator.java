/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming5;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class Opinionator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best");
        System.out.println("I know! Random can decide FOR ME!");
        
        int x = randomizer.nextInt(6);// was 5 but we need 5 as a value so changing to 6
        
        System.out.println("The number we chose was: " + x);
        
        if (x == 0) {
            System.out.println("Llamas are the best!");
        } else if (x == 1) {
            System.out.println("Dodos are the best!");
        } else if (x == 2) {
            System.out.println("Woolly Mammoths are Definietly the best!");
        } else if (x == 3) {
            System.out.println("Sharks are the greatest, they have their own week!");
        } else if (x == 4) {
            System.out.println("Cockatoos are just so awesome!");
        } else if (x == 5) {
            System.out.println("Have you ever met a Mole-Rat?  They're great!");
        }
        
        System.out.println("Thanks Random, maybe You're the best!");
    }
}
