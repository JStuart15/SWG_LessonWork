/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practiceprogramming2;

/**
 *
 * @author jstuart15
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        String menuItem1 = "Pizza";
        String menuItem2 = "Philly Cheesesteak";
        String menuItem3 = "Chicken Curry";
        
        float menuItem1Cost = 15.99f;
        float menuItem2Cost = 8.99f;
        float menuItem3Cost = 12.99f;
               
        System.out.println(".......................................................................");
        System.out.println(".   o   \\ o /  _ o        __|    \\ /     |__         o _  \\ o /   o   .");
        System.out.println(".  /|\\    |     /\\   __\\o   \\o    |    o/     o/__   /\\     |    /|\\  .");
        System.out.println(".  / \\   / \\   | \\  /) |    ( \\  /o\\  / )    |   (\\  / |   / \\   / \\  .");
        System.out.println(".......................................................................");
        
        System.out.println("              Welcome to my restaurant Native Tongues");
        System.out.println("                        Today's Menu is...");
        
        System.out.println("\n\n                   " + menuItem1 + "\t\t\t" + menuItem1Cost);
        System.out.println("                   " + menuItem2 + "\t\t" + menuItem2Cost);
        System.out.println("                   " + menuItem3 + "\t\t" + menuItem3Cost);

    }
}
