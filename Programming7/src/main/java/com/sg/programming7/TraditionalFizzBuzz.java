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
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How much units fizzing and buzzing do you need in your life?");
        int numberFizzBuzz = sc.nextInt();
        int counter = 0;

        for (int i = 0; numberFizzBuzz > counter; i++){
            if (i != 0 && i % 3 == 0 && i % 5 == 0){
                System.out.println("fizz buzz");
                counter += 2;
            } else if (i != 0 && i % 3 == 0){
                System.out.println("fizz");
                counter++;
            } else if (i !=0 && i % 5 == 0){
                System.out.println("buzz ");
                counter++;
            } else{
                System.out.println(i);
            }
            
        }
       
        System.out.println("TRADITION!!!");
    }
}
