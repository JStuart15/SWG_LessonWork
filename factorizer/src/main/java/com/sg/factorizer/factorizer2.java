/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class factorizer2 {

    public void factorize() {
        Scanner sc = new Scanner(System.in);

        System.out.print("What number would you like to factor?");
        int number = sc.nextInt();

        int biggestFactor = number / 2;//the biggest factor, besides the number itself, is half of it. e.g. 18 is largest factor of 36
        int primeNumberSum = 0;
        int perfectNumberSum = 0;

        for (int i = 1; i <= biggestFactor; i++) {
            if (number % i == 0) {
                System.out.println(i);
                perfectNumberSum += i;
                primeNumberSum += 1;
            }
        }
        System.out.println(number);
        if (perfectNumberSum == number) {
            System.out.println(number + " is a perfect number");
        } else {
            System.out.println(number + " is not a perfect number");
        }
        if (primeNumberSum == 1) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}
