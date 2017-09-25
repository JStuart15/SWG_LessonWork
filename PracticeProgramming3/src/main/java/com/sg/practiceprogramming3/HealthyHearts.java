package com.sg.practiceprogramming3;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int age;
        
        System.out.print("What is your age? ");
        age = sc.nextInt();
        
        System.out.println("Your maximum heart rate should be " + (220 - age) + " beats per minute");
        System.out.println("Your target HR Zone is " + ((220 - age) * .5) + " - " + ((220 - age) * .85));
    }
}
