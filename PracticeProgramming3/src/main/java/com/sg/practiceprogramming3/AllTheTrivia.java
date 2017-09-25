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
public class AllTheTrivia {
    public static void main(String[] args) {
        String gigabytes;
        String clockwisePlanet;
        String largestVolcano;
        String mostAbundantElement;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("1,024 Gigabytes is equal to one what? ");
        gigabytes = sc.nextLine();
        
        System.out.print("In our solar system which is the only planet that rotates clockwise? ");
        clockwisePlanet = sc.nextLine();
        
        System.out.print("The largest volcano ever discovered in our solar system is located on which planet? ");
        largestVolcano = sc.nextLine();
        
        System.out.print("What is the most abundant element in the earth's atmosphere? ");
        mostAbundantElement = sc.nextLine();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + largestVolcano);
        System.out.println("I didn't know that the largest ever volcano was discovered on " + gigabytes);
        System.out.println("That's amazing that " + clockwisePlanet + " is the most abundant element in the atmosphere...");
        System.out.println(mostAbundantElement + " is the only planet that rotates clockwise, so cool!");
    }
}
