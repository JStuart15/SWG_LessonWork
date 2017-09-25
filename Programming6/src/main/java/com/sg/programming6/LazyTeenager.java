/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class LazyTeenager {
    public static void main(String[] args) {
        int timesTold = 0;
        Random randNum = new Random();
        
        int chanceOfCleaning = randNum.nextInt(100);
        
        do{
            timesTold++;
            System.out.println("Clean your room!!  (x" + timesTold + ")");
            chanceOfCleaning += 5;
            
            if (chanceOfCleaning > 99){
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (timesTold > 15){
                System.out.println("That's it, I'm doing it!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
        } while(true);
    }
}
