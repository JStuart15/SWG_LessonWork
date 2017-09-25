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
public class TriviaNight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer1;
        int answer2;
        int answer3;
        int totalCorrect = 0;
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        
        System.out.println("First Question!");
        System.out.println("What is the lowest level programming language?");
        System.out.println("1) Source Code\t\t\t2) Assembly Language");
        System.out.println("3) C#\t\t\t4) Machine Code\n");
        System.out.print("YOUR ANSWER: ");
        answer1 = sc.nextInt();
        if (answer1 == 4){
            totalCorrect++;
        }
        
        System.out.println("SECOND Question!");
        System.out.println("Website Security CAPTCHA forms are descended from the work of?");
        System.out.println("1) Grace Hopper\t\t\t2) Alan Turing");
        System.out.println("3) Charles Babbage\t\t\t4) Larry Page\n");
        System.out.print("YOUR ANSWER: ");
        answer2 = sc.nextInt();
        if (answer2 == 2){
            totalCorrect++;
        }      
        
        System.out.println("THIRD Question!");
        System.out.println("which of these sci-fi ships was once slated for a full-size replica in Las Vegas?");
        System.out.println("1) Serenity\t\t\t2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise\t\t\t4) The Millennium Falcon\n");
        System.out.print("YOUR ANSWER: ");
        answer3 = sc.nextInt();
        if (answer3 == 3){
            totalCorrect++;
        }
        
        if (totalCorrect > 0){
            System.out.println("Nice job - you got " + totalCorrect + " correct!");
        } else {
            System.out.println("Unfortunately you didn't get any correct.");
        }
    }
}
