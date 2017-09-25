/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class HighRoller {
    public static void main(String[] args) {
        Random diceRoller = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many sides does your die have?");
        int sides = sc.nextInt();
        
        int rollResult = diceRoller.nextInt(sides) + 1;
        System.out.println("TIME TO ROOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);
        
        if (rollResult == 1){
            System.out.println("You rolled a critical failure");
        }
        
        if (rollResult == sides){
            System.out.println("You rolled a critical! Nice job!");
        }
    }
  
}
