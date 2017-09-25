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
public class FieldDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What's your last name?");
        String name = sc.next();
        
        if ((name.compareToIgnoreCase("Baggins")) < 0){
            System.out.println("");
            System.out.println("You're on the team 'Red Dragons'");
        }
        if ((name.compareToIgnoreCase("Baggins")) >= 0 && (name.compareToIgnoreCase("Dresden") < 0)) {
            System.out.println("Your on the team 'Dark Wizards'");
        } 
        if ((name.compareToIgnoreCase("Dresden") >= 0) && (name.compareToIgnoreCase("Howl") < 0)){
            System.out.println("You're on the team 'Moving Castles'");
        }
        
        if ((name.compareToIgnoreCase("Howl") >= 0) && (name.compareToIgnoreCase("Potter") < 0)){
            System.out.println("You're on the team 'Golden Snitches'");
        }
        
        if ((name.compareToIgnoreCase("Potter") >= 0) && (name.compareToIgnoreCase("Vimes") < 0)){
            System.out.println("You're on the team 'Night Guards'");
        }
        
        if ((name.compareToIgnoreCase("Vimes")) >= 0){
            System.out.println("You're on the team 'Black Holes'");
        }
        System.out.println("Good luck in the games!");
    }
}
