/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class GuessMeFinally {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int guess;
        int chosenNumber = rand.nextInt(200) - 100;
        System.out.println("I've chosen a number between -100 and 100.  Betcha can't gues it!");
        System.out.println("The number is: " + chosenNumber);
        int attempts = 0;
        
        do{
            System.out.print("\nYour guess:  ");
            guess = sc.nextInt();
            if (guess < chosenNumber){
                System.out.print("Ha, nice try - too low! Try again");
            } else if (guess > chosenNumber){
                System.out.println("Too high, try again.");
            }
            attempts++;
        }while (guess != chosenNumber);
     
            if (attempts <= 1){
                System.out.println("Wow, nice guess! That was it!");
            } else{
                System.out.println("Finally! It's about time you got it.");
            }
                
    }
}
