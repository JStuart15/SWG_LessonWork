package com.sg.practiceprogramming3;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class MiniMadLibs {
    public static void main(String[] args) {
        String noun1;
        String adjective1;
        String noun2;
        int number;
        String adjective2;
        String pluralNoun1;
        String pluralNoun2;
        String pluralNoun3;
        String presentVerb;
        String pastVerb;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("I need a noun: ");
        noun1 = sc.nextLine();
        
        System.out.print("Now an adj: ");
        adjective1 = sc.nextLine();
        
        System.out.print("Another noun: ");
        noun2 = sc.nextLine();
        
        System.out.print("And a number: ");
        number = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Another adj: ");
        adjective2 = sc.nextLine();
        
        System.out.print("A plural noun: ");
        pluralNoun1 = sc.nextLine();
        
        System.out.print("Another one: ");
        pluralNoun2 = sc.nextLine();
        
        System.out.print("One more: ");
        pluralNoun3 = sc.nextLine();
        
        System.out.print("A verb (present tense): ");
        presentVerb = sc.nextLine();
        
        System.out.print("A verb (past tense): ");
        pastVerb = sc.nextLine();
        
        System.out.println("\n" + noun1 + " the " + adjective1 + " frontier.  These are the voyages of the starship " 
        + noun2 + ". Its " + number + "-year mission: to explore strange " + adjective2 + " " + pluralNoun1 + ", to seek out "
        + adjective2 + " " + pluralNoun2 + " and " + adjective2 + " " + pluralNoun3 + ", to boldly " + presentVerb 
                + " where no one has " + pastVerb);
    }
}
