/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming9;

import java.util.Arrays;

/**
 *
 * @author jstuart15
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        String[] fruitSalad = new String[12];
        
        int fruitSaladIndex = 0;
        
        //add some berries
        for (int i = 0; i < fruit.length; i++){
            if(fruit[i].contains("berry")){
                fruitSalad[fruitSaladIndex] = fruit[i];
                fruitSaladIndex++;
            }
        }
        int[] arr = new int[6];
        
        //add some apples
        int appleCounter = 0;
            for (int i = 0; i < fruit.length; i++){
                if(fruit[i].contains("apple") || 
                   fruit[i].contains("Apple") &&
                   appleCounter < 3){
                    fruitSalad[fruitSaladIndex] = fruit[i];
                    fruitSaladIndex++;
                    appleCounter++;
                }
            }
        
         //add some oranges
         int orangeCounter = 0;
         for (int i = 0; i < fruit.length; i++){
                if(fruit[i].contains("orange") || 
                   fruit[i].contains("Orange") &&
                   orangeCounter < 2){
                    fruitSalad[fruitSaladIndex] = fruit[i];
                    fruitSaladIndex++;
                    orangeCounter++;
                }
            }
         
         displayArray(fruitSalad);
    }
    
    
    public static void displayArray(String[] array){
        for (String s : array){
            System.out.print(s + ", ");
        }
    }
    
    }

