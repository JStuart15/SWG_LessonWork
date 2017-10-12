/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.warmups;

/**
 *
 * @author jstuart15
 */
public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        long n1 = 0, n2 = 1, n3;
        long sum = 0;
        do {
            n3 = n2 + n1;
            if (n3 % 2 == 0) {
                System.out.println("found an even" + n3);
                sum += n3;
            }
            n1 = n2;
            n2 = n3;
        } while (n3 < 2147483647);
        System.out.println("The sum of evens is: " + sum);

        //Sum of Prime Numbers
        n1 = 0;
        n2 = 1;
        n3 = 0;
        sum = 0;

        do {
            n3 = n2 + n1;
            //figure out if n3 is prime
            if (isPrime(n3)) {
                sum += n3;
            }
            n1 = n2;
            n2 = n3;
        } while (n3 < 2147483647);
        System.out.println("The sum of primes is: " + (sum - 1));
    }

    public static boolean isPrime(long value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        System.out.println("found prime" + value);
        return true;
    }
}
