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
public class YourLifeInMovies {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String name;
        int yearBorn;
        
        System.out.print("Hey, let's play a game! Whats your name?");
        name = sc.nextLine();
        System.out.print("Ok, " + name + ", when were you born?");
        yearBorn = sc.nextInt();
        
        System.out.println("Well " + name + "...");
        
        if (yearBorn < 2005){
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        }
        if (yearBorn < 1995){
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        if (yearBorn < 1985){
            System.out.println("Space Jam came out not last decade but the one before THAT.");
        }
        if (yearBorn < 1975){
            System.out.println("The original Jurassic park release is closer to the lunar landing, than today");
        }
        if (yearBorn < 1965){
            System.out.println("MASH has been around for almost half a century!");
        }
    }
}
