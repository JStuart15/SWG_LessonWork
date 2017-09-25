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
public class KnockKnock {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Knock Knock! Guess who!!");
        String nameGuess = inputReader.nextLine();
        
        if (nameGuess.equals("Marty McFly")){ //if we use == it won't evaluate properly
            //if the name is not capitalized properly it will fail.  We could put it to caps and do the comparison.
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future.");
        } else{
            System.out.println("Dude, do I - look - like " + nameGuess);
        }
        
    }
}
