/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {
        
        String color = getColor();
        String animal = getAnimal();
        String colorAgain = getColor();
        int weight = getWeight();
        int distance = getDistance();
        int number = getNumber();
        int time = getTime();
        
        System.out.println("Once, when I was very small...");
        System.out.println("I was chased by a " + color + ", "
            + weight + "lb" + " miniature " + animal 
            + " for over " + distance + " miles!!");
        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    }
    
    public static String getAnimal(){
        Random randNum = new Random();
        String animal="";
        int number = randNum.nextInt(5) + 1;
        switch (number) {
            case 1:
                animal = "Chimpanzee";
                break;
            case 2:
                animal = "Lion";
                break;
            case 3:
                animal = "Dragonfly";
                break;
            case 4:
                animal = "Dog";
                break;
            case 5:
                animal = "Cat";
                break;
        }
        return animal;
    }
    
        public static String getColor(){
        Random randNum = new Random();
        String color="";
        int number = randNum.nextInt(5) + 1;
        switch (number) {
            case 1:
                color = "red";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "fushia";
                break;
            case 4:
                color = "purple";
                break;
            case 5:
                color = "black";
                break;
        }
        return color;
    }
        
    public static int getWeight(){
        Random randNum = new Random();
        int weight = randNum.nextInt(195) + 5;
        return weight;
    }
        
    public static int getDistance(){
        Random randNum = new Random();
        int distance = randNum.nextInt(10) + 10;
        return distance;
    }
    
    public static int getNumber(){
        Random randNum = new Random();
        int number = randNum.nextInt(10000) + 10000;
        return number;
    }
    
    public static int getTime(){
        Random randNum = new Random();
        int time = randNum.nextInt(10000) + 10000;
        return time;        
    }
}
