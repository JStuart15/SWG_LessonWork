/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collectionexamples;

import java.util.Stack;

/**
 *
 * @author jstuart15
 */
public class StackExample {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
            System.out.print(", ");
            
        }
        System.out.println("lift off");
    }
}
