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
public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("random can make integers: " + randomizer.nextInt());
        System.out.println("or a double " + randomizer.nextDouble());
        System.out.println("or even a boolean " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        
        System.out.println("You can store a randomized result: " + num);
        System.out.println("and use it over and over again " + num + ", " + num);
        System.out.println("or just keep generating new values");
        System.out.println("here's a bunch of numbers from 0 - 100");
        System.out.print((randomizer.nextInt(50) + 50) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println((randomizer.nextInt(50)+50));
        // adding 50 shifts the numbers of 0 to 50 to 50 to 100;
        
    }  
    
}
