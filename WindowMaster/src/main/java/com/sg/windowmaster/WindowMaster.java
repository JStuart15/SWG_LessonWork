/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmaster;

import static java.lang.Math.round;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class WindowMaster {
    public static void main(String[] args) {
        float height;
        float width;
        
        String stringHeight;
        String stringWidth;
        
        float areaOfWindow;
        float perimeterOfWindow;
        float cost;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is the height of window in feet?:");
        stringHeight = sc.nextLine();
        
        System.out.println("What is the width of window in feet?:");
        stringWidth = sc.nextLine();
        
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Height" + stringHeight);
        System.out.println("Width" + stringWidth);
        System.out.println("Area" + areaOfWindow);
        System.out.println("Perimeter" + perimeterOfWindow);
        System.out.println("The cost is $" + cost);
    }
}
