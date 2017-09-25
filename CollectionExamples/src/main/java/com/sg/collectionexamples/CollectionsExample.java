/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collectionexamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,1,2,3,5,8,13,21,34,55);
        System.out.println("Position of 21: " + Collections.binarySearch(list1, 21));
        
    }
}
