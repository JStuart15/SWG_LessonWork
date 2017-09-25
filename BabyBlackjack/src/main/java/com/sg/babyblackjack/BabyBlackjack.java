/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.babyblackjack;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class BabyBlackjack {
    public static void main(String[] args) {
        Random rgen = new Random();
        
        int playerCard1 = rgen.nextInt(10) + 1;
        int playerCard2 = rgen.nextInt(10) + 1; 
        int playerSum = playerCard1 + playerCard2; 
        System.out.println("Baby Blackjack!");
        System.out.println("You drew " + playerCard1 + " and "
            + playerCard2);
        System.out.println("Your total is " + playerSum);
        
        int dealerCard1 = rgen.nextInt(10) + 1;
        int dealerCard2 = rgen.nextInt(10) + 1;
        int dealerSum = dealerCard1 + dealerCard2;
        System.out.println("\nThe dealer has " + dealerCard1 + " and "
            + dealerCard2);
        System.out.println("Dealer's total is " + dealerSum);
        
        
    }
    
}
