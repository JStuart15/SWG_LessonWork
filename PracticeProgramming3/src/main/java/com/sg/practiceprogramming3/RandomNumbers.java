/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practiceprogramming3;

import java.util.Random;

/**
 *
 * @author jstuart15
 */
public class RandomNumbers {
    public static void main(String[] args) {
        int day = 7;
        String dayType = "";
        
        switch (day){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid Day";
        }
        System.out.println(dayType);
    }
}
