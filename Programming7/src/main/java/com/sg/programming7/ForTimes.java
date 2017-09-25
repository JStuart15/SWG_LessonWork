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
public class ForTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Which times table shall I recite?");
        int number = sc.nextInt();
        int numberCorrect = 0;
        
        for (int i = 1; i < 16; i++){
            System.out.print(i + " * " + number + " is? ");
            int answer = sc.nextInt();
            if (answer == i*number){
                System.out.println("Correct");
                numberCorrect++;
            } else {
                System.out.println("Sorry no, the answer is: " + i*number);
            }
                 
        }
        System.out.println("You got " + numberCorrect + " correct.");
        if (((float) numberCorrect/15) < .50){
            System.out.println("You need some help, go study");
        }
        if (((float) numberCorrect/15) > .90){
            System.out.println("Congratulations, you got an A");
        }
    }
}
