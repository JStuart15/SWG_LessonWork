/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arraylistexamples;

import java.util.ArrayList;

/**
 *
 * @author jstuart15
 */
public class ArrayListExamples {

    public static void main(String[] args) {
        //create an ArrayList of String objects
        ArrayList<String> stringList = new ArrayList<>();

        //ask the list how big it is
        System.out.println("list size before adding any strings "
                + stringList.size());

        //add a String object to our list
        stringList.add("My first string");

        //ask the list how big it is
        System.out.println("list size after adding one string "
                + stringList.size());

        //add another String ojbect to list
        stringList.add("My Second String");

        //ask the list how big it is
        System.out.println("list size after adding one string "
                + stringList.size());

        //Removing Elements
        // remove the second String object from our list - remember that
        // our indexes start counting at 0 instead of 1
        stringList.remove(1);

        //ask the list how big it is
        System.out.println("list size after adding one string "
                + stringList.size());

        // remove the remaining String object from our list - remember
        // that the list resizes automatically so if there is only one
        // element in a list it is always at index 0
        stringList.remove(0);

        //ask the list how big it is
        System.out.println("Size of list "
                + stringList.size());
        
        //Enhanced Loop Examples
        stringList.add("My first string");
        stringList.add("My second string");
        stringList.add("My third string");
        stringList.add("My fourth string");
        System.out.println("Size of list for looping: " + stringList.size());
        for(String currentString : stringList){
            System.out.println(currentString);
        }
    }
}
