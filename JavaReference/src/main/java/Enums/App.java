/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

import java.time.DayOfWeek;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Select a day of the week ");
        String userInput = sc.nextLine();
        
        DayOfWeek day = DayOfWeek.valueOf(userInput.toUpperCase());
        
        switch (day){
            case MONDAY:
                System.out.println("4 days until Friday");
                break;
            case TUESDAY:
                System.out.println("3 days until Friday");
                break; 
            case WEDNESDAY:
                System.out.println("2 days until Friday.");
                break;
            case THURSDAY:
                System.out.println("1 day until Friday.");
                break;
            case FRIDAY:
                System.out.println("It's Friday!");
                break;
            case SATURDAY:
                System.out.println("6 days until Friday");
                break;
            case SUNDAY:
                System.out.println("5 days until Friday");
                break;                                        
        }
        
        
    }

}
