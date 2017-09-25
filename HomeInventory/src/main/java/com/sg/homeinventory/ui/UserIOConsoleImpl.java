/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.ui;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        String input = sc.nextLine();
        return Double.parseDouble(input);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            print(prompt);
            String input = sc.nextLine();
            double d = Double.parseDouble(input);
            if (d >= min && d <= max) {
                return d;
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        String input = sc.nextLine();
        return Float.parseFloat(input);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            print(prompt);
            String input = sc.nextLine();
            float f = Float.parseFloat(input);
            if (f >= min && f <= max) {
                return f;
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        int i = 0;
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        print(prompt);
        String input = sc.nextLine();
        int i = Integer.parseInt(input);
        return i;
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        String input = sc.nextLine();
        return Long.parseLong(input);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            print(prompt);
            String input = sc.nextLine();
            long l = Long.parseLong(input);
            if (l >= min && l <= max) {
                return l;
            }
        } while (true);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}
