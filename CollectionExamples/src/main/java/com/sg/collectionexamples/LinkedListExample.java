/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collectionexamples;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Linked Lists are good when you know that you will be inserting items in the 
 * middle of the list in the future
 * 
 * @author jstuart15
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList states = new LinkedList();
        states.add("alaska");
        states.add("arizona");
        states.add("arkansas");
        states.add("pennsylvania");
        states.add("california");
        states.add("colorado");
        states.add("conneticut");
        
        states.addFirst("alabama");
        System.out.println(states);
        System.out.println("last state " + states.getLast());
        
        //print the list in reverse order
        ListIterator iterator = states.listIterator(states.size());
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
