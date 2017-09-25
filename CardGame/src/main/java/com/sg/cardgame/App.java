/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardgame;

import java.util.Arrays;

/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        Deck d = new Deck();
        Card[] deal = d.deal(10);

        for (int i = 0; i < deal.length; i++) {
            System.out.println("Card " + i + 1 + " is " + deal[i].getFaceValue()
                    + " of " + deal[i].getSuit());
        }
    }
}
