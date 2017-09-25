/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        
        Random rand = new Random();
        int numPedals = rand.nextInt(76) + 13;
        System.out.println("Number of pedals is: " + numPedals);
        do{
            if (numPedals % 2 == 0){
                System.out.println("It loves me NOT!");
            }else{
                System.out.println("It LOVES me!");
            }
            
            numPedals--;
        }while (numPedals > 0);
        
        if (numPedals % 2 == 0){
            System.out.println("Ow, wow! It really LOVES me!");
        } else {
            System.out.println("Awwww, bummer.");
        }
    }
}
