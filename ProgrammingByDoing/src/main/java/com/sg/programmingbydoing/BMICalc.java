/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programmingbydoing;

import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class BMICalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your height in inches: ");
        double height = sc.nextDouble();
        System.out.println("Your weight in pounds: ");
        double weight = sc.nextDouble();
        
        System.out.println("Your BMI is " + getBMI(height, weight));
        System.out.println("BMI Category: " + 
                getBMICategory(getBMI(height, weight)));
        
        showNormalWeightRange(height, weight);
    }
    
    public static double getBMI(double height, double weight){
        double bmi = (weight * 0.454) / (Math.pow((height*.0254), 2));
        return bmi;
        
        // 1" = 0.0254 meters
        // 1lb = 0.454kg
    }
    
    public static String getBMICategory(double bmi){
        String category = "";
        if (bmi <= 18.5){
            category = "underweight";
        } else if (bmi > 18.5 && bmi <= 24.9){
            category = "normal weight";
        } else if (bmi > 24.9 && bmi <= 29.9 ){
            category = "overweight";
        } else if (bmi > 30.0){
            category = "obese";
        }
        return category;
    }
    
    public static void showNormalWeightRange(double height, double weight){
        double minNormalBMI = 18.5;
        double maxNormalBMI = 24.9;
        double minWeight = 0;
        double maxWeight = 0;
        
        minWeight = (minNormalBMI * (Math.pow((height*.0254), 2)))/0.454;
        maxWeight = (maxNormalBMI * (Math.pow((height*.0254), 2)))/0.454;

        System.out.println("In order for you to be considered normal,\nyou would"
                + " need to weigh between " + Math.round(minWeight) + " and " 
                + Math.round(maxWeight));
    }
}
