/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class LuckySevens {

    public void playLuckySevens() {
        Scanner sc = new Scanner(System.in);
        int rolls = 0;
        int quitRolls = 0;
        int maxDollars = 0;
        int dollars = 0;

        System.out.print("How many dollars do you have? ");
        dollars = sc.nextInt();
        maxDollars = dollars;

        while (dollars > 0) {
            rolls++;
            int dice1 = rollDie();
            int dice2 = rollDie();
            int sum = dice1 + dice2;

            if (sum == 7) {
                dollars += 4;
            } else {
                dollars -= 1;
            }

            if (dollars > maxDollars) {
                maxDollars = dollars;
                quitRolls = rolls;
            }

        }

        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + quitRolls
                + " rolls when you had $" + maxDollars);
    }

    public static int rollDie() {
        Random randNum = new Random();
        int number = randNum.nextInt(6) + 1;
        return number;
    }
}
