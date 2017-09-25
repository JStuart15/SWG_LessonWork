/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming7;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class GuessMe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int guess; 
        int number = 9;    
        
        System.out.println("I've chosen a number.  Betcha can't guess it!");
        System.out.print("Your guess?: ");
        guess = sc.nextInt();
        
        if (guess == number){
            System.out.println("Wow, nice guess! That was it!");
        }
        if (guess < number){
            System.out.println("Ha, nice try - too low! I chose " + number);
        }
        if (guess > number){
            System.out.println("Too bad, way too high. I chose " + number);
        }
    }
}
