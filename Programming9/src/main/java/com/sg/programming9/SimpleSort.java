/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programming9;

/**
 *
 * @author jstuart15
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        int[] wholeNumbers = new int[24];
        
        System.out.println();
        fillArray(firstHalf, wholeNumbers);
        fillArray(secondHalf, wholeNumbers);
        System.out.println("Prior to sort, here is your full array.");
        displayArray(wholeNumbers);
        System.out.println("");
        System.out.println("Here you go - all nice and ordered:");
        sortArray(wholeNumbers);
        displayArray(wholeNumbers);
    }
    
    public static void sortArray(int[] array){
        int temp = 0;
        
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static void fillArray(int[] partialArray, int[] fullArray){
        
        for (int i = 0; i < partialArray.length; i++){
            for(int j = 0; j < fullArray.length; j++){
                if (fullArray[j] == 0) {
                    fullArray[j] = partialArray[i];
                    break;
                }
            }
        }
    }
    
    public static void displayArray(int[] array){
        for (int num : array){
            System.out.print(num + " ");
        }
    }
}
