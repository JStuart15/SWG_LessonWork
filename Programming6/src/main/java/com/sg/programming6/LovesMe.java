/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

/**
 *
 * @author jstuart15
 */
public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        int numPedals = 34;
        
        do{
            if (numPedals % 2 == 0){
                System.out.println("It loves me NOT!");
            }else{
                System.out.println("It LOVES me!");
            }
            
            numPedals--;
        }while (numPedals > 0);
    }
}
