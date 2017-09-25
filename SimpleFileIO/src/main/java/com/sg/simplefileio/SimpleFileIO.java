/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class SimpleFileIO {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));//will create file if it doesn't exist
        
        out.println("this is a line in my file....");//this will overwrite the existing file
        out.println("This is a second line in my file");
        out.println("This is a third line in my file");
        out.flush(); //force everything in the buffer to write to the file.
        out.close(); //resources (db's, files) need to be closed
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
        
        while (sc.hasNextLine()){
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
        System.out.println("\nThat's all the content in the file");
    }
}
