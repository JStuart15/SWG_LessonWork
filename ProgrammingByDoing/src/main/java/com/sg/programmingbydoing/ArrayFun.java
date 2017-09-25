/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programmingbydoing;

/**
 *
 * @author jstuart15
 */
public class ArrayFun {
    public static void main(String[] args) {
        int[] teamScores = {42, 3023, 15, 16, 73, 93, 1, 9};
        displayArray(teamScores);
        System.out.println("");
        sortArray(teamScores);
        displayArray(teamScores);//how is this displaying the right values if I didn't return the array?
        displayMinMaxSumOfArray(teamScores);
    }
    
    public static void displayArray(int[] integerArray){
        for (int num : integerArray){
            System.out.print(num + ", ");
        }
        System.out.println("");
    }
    
    public static void sortArray(int[] integerArray){
        System.out.print("Sorted in order: ");

        for (int i = 0; i < integerArray.length; i++){
            int temp;
            //boolean hasSwaps = true;
            
            for (int j = 0; j < integerArray.length - 1; j++)
                if (integerArray[j] > integerArray[j+1]){
                    temp = integerArray[j];
                    integerArray[j] = integerArray[j+1];
                    integerArray[j+1] = temp;
                    //hasSwaps = true;
                }
                //if (!hasSwaps){
                //    break;
                //}
        }
    }
    
    public static void displayMinMaxSumOfArray(int[] integerArray){
        int min = integerArray[0];
        int max = integerArray[0];
        int sum = 0;
        
        for (int i = 0; i < integerArray.length; i++){
            sum += integerArray[i];
            if (integerArray[i] < min){
                min = integerArray[i];
            }
            if (integerArray[i] > max){
                max = integerArray[i];
            }
        }
        System.out.println("Max in array is: " + max);
        System.out.println("Min in array is: " + min);
        System.out.println("sum of the array is: " + sum);
    }
}
