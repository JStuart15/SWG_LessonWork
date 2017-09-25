/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardgame;

/**
 *
 * @author jstuart15
 */
public class Card {

    private String faceValue;
    private String suit;
    private Boolean cardUsed = false;

    //getters and setters
    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Boolean getCardUsed() {
        return cardUsed;
    }

    public void setCardUsed(Boolean cardUsed) {
        this.cardUsed = cardUsed;
    }

}
