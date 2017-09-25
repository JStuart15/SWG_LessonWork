/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming9;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the annual interest rate: ");
        double intRate = sc.nextDouble();
        
        System.out.print("Please enter the initial principal: ");
        double inPrincipal = sc.nextDouble();
        
        System.out.print("Please enter the number of years to stay in the fund: ");
        int years = sc.nextInt();
        
        double endPrincipal = 0;
        
        for (int i =1; i <= years; i++){
            System.out.print("Year " + years);
        }
    }

}
