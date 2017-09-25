/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practiceprogramming2;

/**
 *
 * @author jstuart15
 */
public class TheOrderOfThings {
    public static void main(String[] args) {
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = " awesome ";
        size = " teensy-weensy ";
        age = " new ";
        shape = " oblong ";
        color = " Bright yellow ";
        origin = " AlphaCentaurian ";
        material = " platinum ";
        purpose = " good ";
        noun = " dragons ";
        
        // Using the + with strings, doesn't add it it concatenates! 
        System.out.println(number + opinion + size + age + shape + color + origin
                            + material + purpose + noun);
        
        System.out.println(age + number + purpose + shape + opinion + size + color
                            + material + origin + noun);
    }
}
