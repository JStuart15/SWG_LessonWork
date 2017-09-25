/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fileexamples;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        File directory = new File("./", "orderFiles");
        directory.mkdir();
        File f1 = new File("./orderFiles", "orders_" + LocalDate.now() + ".txt");
        
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
        System.out.println(f1.exists());
        try {
            f1.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
        System.out.println(f1.exists());
    }

}
