/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class factorizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number would you like to factor?");
        
        int number = sc.nextInt();
        System.out.println("The factors of " + number + " are:");
        int perfectNumberSum = 0;
        int primeNumber = 0;
            
        //Determine factors
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                System.out.println(i);
                perfectNumberSum += i;
                primeNumber += 1;
            }

        }
        
        if (perfectNumberSum == number){
            System.out.println(number + " is a perfect number.");
            } else { 
                System.out.println(number + " is not a perfect number");
            }
        
        if (primeNumber == 1) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}
