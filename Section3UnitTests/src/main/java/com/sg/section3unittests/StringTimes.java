/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section3unittests;

/**
 *
 * @author jstuart15
 */
public class StringTimes {
    public static void main(String[] args) {
        System.out.println(stringTimes("Hi", 3));
    }
    // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    public static String stringTimes(String str, int n) {
        String returnString = "";
        for (int i = 1; i <= n; i++){
            returnString += str;
        }
        return returnString;
    }
    
}
