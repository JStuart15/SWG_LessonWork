/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming7;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class TheCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        
        System.out.print("Start at? ");
        int start = sc.nextInt();
        
        System.out.print(" Stop at? ");
        int end = sc.nextInt();
        
        System.out.print("Count by? ");
        int increment = sc.nextInt();
        int numsPrinted = 1;
        
        for (int i = start; i < end; i+=increment){
            System.out.print(i + " ");
            if (numsPrinted % 3 == 0){
                System.out.println("- Ah ah ah!");
            }
            numsPrinted++;
        }
    }
}
