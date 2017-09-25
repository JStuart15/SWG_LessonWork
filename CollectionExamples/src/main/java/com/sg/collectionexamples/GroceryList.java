/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collectionexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class GroceryList {

    public static void main(String[] args) {

        List<String> grocery1 = new ArrayList(Arrays.asList("ramen", "beef", "banana"));

        List<String> grocery2 = new ArrayList<>();
        grocery2.add("Cucumber");
        grocery2.add("bell pepper");
        grocery2.add("cabbage");

        grocery1.addAll(grocery2);
        System.out.println(grocery1);

        grocery1.remove(grocery1.indexOf("cabbage"));
        System.out.println(grocery1);
    }

}
