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
public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name;
        String favoriteColor;
        String favoriteFood;
        double favoriteNumber;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hello there!");
        
        System.out.print("Whats your name? ");
        name = sc.nextLine();
        
        System.out.print("\nHi " + name + "! What's your favorite color? ");
        favoriteColor = sc.nextLine();
        
        System.out.println("\nHuh, " + favoriteColor + "?  Mine's Electric Lime.");
        System.out.println("\nI really like limes.  They're my favorite fruit, too.");
        
        System.out.print("What's YOUR favorite fruit, " + name + "? ");
        favoriteFood = sc.nextLine();
        System.out.println("\nReally? " + favoriteFood + "? That's wild!");
        
        System.out.print("Speaking of favorites, what's your favorite number? ");
        favoriteNumber = sc.nextDouble();
        System.out.println("\n" + favoriteNumber + " is a cool number.  Mine's -7.");
        System.out.println("Did you know " + favoriteNumber + " * -7 is " + favoriteNumber*-7 + " That's a cool number too!");
        
        System.out.println("\nWell, thanks for talking to me, " + name);
    }
}
