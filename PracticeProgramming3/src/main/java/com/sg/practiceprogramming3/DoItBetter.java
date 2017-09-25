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
public class DoItBetter {
    public static void main(String[] args) {
        double numberMiles;
        double numberHotDogs;
        int numberOfLanguages;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many miles can you run? ");
        numberMiles = sc.nextDouble();
        System.out.println("That's interesting, I can run " + (numberMiles * 2 + 1));
        
        System.out.print("How hot dogs can you eat? ");
        numberHotDogs = sc.nextDouble();
        System.out.println("That's a low number, I can eat " + (numberHotDogs * 2 + 1));
        
        System.out.print("How many languages do you speak? ");
        numberOfLanguages = sc.nextInt();
        System.out.println("That's it? I can speak " + (numberOfLanguages * 2 + 1));
    }
}
