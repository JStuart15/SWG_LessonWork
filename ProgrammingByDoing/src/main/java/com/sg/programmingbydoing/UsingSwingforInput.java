/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programmingbydoing;

import javax.swing.JOptionPane;

/**
 *
 * @author jstuart15
 */
public class UsingSwingforInput {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        
        String input = JOptionPane.showInputDialog("How old are you?");
        int age = Integer.parseInt(input);
        
        System.out.print("Hello " + name + ".  ");
        System.out.println("Next year, you'll be " + (age+1));
        System.exit(0);
    }
}
