/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardgame;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class Deck {

    private Card[] cardsInDeck = new Card[52];
    private int currentIndex = 0;
    private Random rng = new Random();

    String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
    String[] faceValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"};

    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < faceValues.length; j++) {
                Card c = new Card();
                c.setFaceValue(faceValues[j]);
                c.setSuit(suits[i]);
                cardsInDeck[currentIndex] = c;
                currentIndex++;
            }
        }
    }

    public Card getCard(int index) {
        return cardsInDeck[index];
    }

    public Card[] deal(int numberToDeal) {
        Card[] randomCards = new Card[numberToDeal];
        for (int i = 0; i < numberToDeal; i++) {
            do{ //avoid duplicates by checking whether the card has been used
               Card c = this.getCard(rng.nextInt(cardsInDeck.length));
                if (c.getCardUsed() == false) {
                    randomCards[i] = c;
                    c.setCardUsed(true);
                }
            } while(randomCards[i] == null);
        }
        return randomCards;
    }
}
