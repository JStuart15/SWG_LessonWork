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
public class InABucket {
    public static void main(String[] args) {
        
        //you can declar all kinds of variables
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;
        
        // but declaring them jus sets up the space for data
        // to use the variable, you have to put data IN it first!
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        weightOfTeacupPig = 150;
        grainsOfSand = 348389393;
        
        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.println("He was a bit hungry today, and ate this many pies : " + piesEaten);
        System.out.println("He weights as much as a teacup pig: " + weightOfTeacupPig);
        System.out.println("Which is equivalent to " + grainsOfSand + " grains of sand.");
    }
}
