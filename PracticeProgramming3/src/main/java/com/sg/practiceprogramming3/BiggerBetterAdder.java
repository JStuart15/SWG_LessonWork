/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practiceprogramming3;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class BiggerBetterAdder {
    
    public static void main(String[] args) {
        float operand1;
        float operand2;
        float operand3;
        float sum;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Enter first number to add: "); 
        operand1 = inputReader.nextFloat();
        
        System.out.print("Enter second number to add: "); 
        operand2 = inputReader.nextFloat();
        
        System.out.print("Enter third number to add: "); 
        operand3 = inputReader.nextFloat();
        
        sum = operand1 + operand2 + operand3;
        
        System.out.println("the total of the three numbers " + operand1 + " , " 
                + operand2 + " ,and " + operand3 + " is " + sum);
    }
        
        
        
}
