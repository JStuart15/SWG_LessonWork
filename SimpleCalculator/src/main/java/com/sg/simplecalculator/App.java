/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.math.BigDecimal;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        int exit = 0;

        while (exit == 0) {
            int menuselection = displayMenu();
            //int menuselection = getMenuSelection();
            if (menuselection == 0) {
                System.out.println("Thank you, goodbye");
                
                break;
            } else {
                BigDecimal a = getOperand();
                BigDecimal b = getOperand();
                if (menuselection == 1) {
                    System.out.println("\n"+ a + " plus " + b + " = " + SimpleCalculator.add(a, b));
                } else if (menuselection == 2) {
                    System.out.println("\n"+ a + " minus " + b + " = " + SimpleCalculator.subtract(a, b));

                } else if (menuselection == 3) {
                    System.out.println("\n"+ a + " times " + b + " = " + SimpleCalculator.multiply(a, b));

                } else if (menuselection == 4) {
                    System.out.println("\n"+ a + " divided by " + b + " = " + SimpleCalculator.divide(a, b));

                }
            }
        }
    }

    public static BigDecimal getOperand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number :");
        BigDecimal number2 = new BigDecimal(sc.nextDouble());
        return number2;
    }

    public static int displayMenu() {
        Scanner sc = new Scanner(System.in);
//        String option = JOptionPane.showInputDialog("What would you like to do?\n" +
//                "\t1 for ADD\n" + 
//                "\t2 for SUBTRACT\n" +
//                "\t3 for MULTIPLY\n" +
//                "\t4 for DIVIDE\n" +
//                "\t0 for EXIT\n" );

        System.out.println("\nWhat would you like to do?");
        System.out.println("\t1 for ADD");
        System.out.println("\t2 for SUBTRACT");
        System.out.println("\t3 for MULTIPLY");
        System.out.println("\t4 for DIVIDE");
        System.out.println("\t0 for EXIT");
        System.out.print("Please enter one: ");
        int menuSelection = sc.nextInt();
        return menuSelection;
    }

    public static int getMenuSelection() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
