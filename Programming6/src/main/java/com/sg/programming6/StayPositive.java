/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming6;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class StayPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number should I count down from? ");
        int number = sc.nextInt();
        System.out.println("Here goes!");
        
        while(number >= 0){
            System.out.print(number + " ");
            number--;
        }
        
        System.out.println("\nWhew, better stop there...!");
    }
}
