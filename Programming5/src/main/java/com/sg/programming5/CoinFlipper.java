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
public class CoinFlipper {
    public static void main(String[] args) {
        Random rand = new Random();
        
        boolean flipResult = rand.nextBoolean();
        System.out.println("Ready, Set, Flip....!!");
        if (flipResult == false){
            System.out.println("You got TAILS!");
        }
        if (flipResult == true){
            System.out.println("You got HEADS!");
        }
    }
}
