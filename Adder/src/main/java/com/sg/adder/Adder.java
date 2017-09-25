/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.adder;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class Adder {
    public static void main(String[] args) {
        int sum = 0;
        
        Scanner sc = new Scanner(System.in);
        
        String stringOperand1 = "";
        String stringOperand2 = "";
        
        System.out.println("Enter the first number to be added:");
        stringOperand1 = sc.nextLine();
        
        System.out.println("Enter the second number to be added:");
        stringOperand2 = sc.nextLine();
        
        
        sum = Integer.parseInt(stringOperand1) + Integer.parseInt(stringOperand2);
        
        System.out.println("the sum is:" + sum);
    }
}
