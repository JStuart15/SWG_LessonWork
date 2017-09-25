/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming9;

/**
 *
 * @author jstuart15
 */
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        int numApples = 0;
        int numOranges = 0;
        
        for (int i = 0; i < fruit.length; i++){
            
            if (fruit[i] == "Apple"){
                numApples++;
            } else if (fruit[i] == "Orange"){
                numOranges++;
            }
        }
        System.out.println("Total# of Fruit in Basket: " + fruit.length);
        System.out.println("Number of Apples: " + numApples);
        System.out.println("Number of Oranges: " + numOranges);
        
        String[] oranges = new String[33];
        String[] apples = new String[28];
        int appleCounter = 0;
        int orangeCounter = 0;
        
        for(int i = 0; i < fruit.length; i++){
            if (fruit[i] == "Orange"){
                //add to oranges array
                oranges[orangeCounter] = fruit[i];
                orangeCounter++;
            } else if (fruit[i] == "Apple"){
                //add to apple array
                apples[appleCounter] = fruit[i];
                appleCounter++;
            }
        }
        System.out.println("\nTotal# of fruit in basket: " + (apples.length + oranges.length));
        System.out.println("Number of Apples: " + apples.length);
        System.out.println("Number of Oranges: " + oranges.length);
    }
}
