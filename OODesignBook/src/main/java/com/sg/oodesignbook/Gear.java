package com.sg.oodesignbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class Gear {
    private int chainring;
    private int cog;
    
    //Constructors
    public Gear(int chainring, int cog) {
        this.chainring = chainring;
        this.cog = cog;
    }
    

    //Getters and Setters
    public int getChainring() {
        return chainring;
    }

    public void setChainring(int chainring) {
        this.chainring = chainring;
    }

    public int getCog() {
        return cog;
    }

    public void setCog(int cog) {
        this.cog = cog;
    }
    
    //methods
    public double getRatio(){
        return (double)chainring/(double)cog;
    }
}
