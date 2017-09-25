/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public double readDouble(String prompt) {
        double doubleVal = 0;
        Boolean keepGoing = true;
        do {
            try {
                println(prompt);
                String input = sc.nextLine();
                doubleVal = Double.parseDouble(input);
                keepGoing = false;
            } catch (Exception e) {
                keepGoing = true;
            }
        } while (keepGoing);
        return doubleVal;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            println(prompt);
            String input = sc.nextLine();
            double d = Double.parseDouble(input);
            if (d >= min && d <= max) {
                return d;
            } else {
                System.out.println("Invalid input, enter a value from"
                        + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt) {
        println(prompt);
        String input = sc.nextLine();
        return Float.parseFloat(input);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            println(prompt);
            String input = sc.nextLine();
            float f = Float.parseFloat(input);
            if (f >= min && f <= max) {
                return f;
            } else {
                System.out.println("Invalid input, enter a value from "
                        + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt) throws FlooringUserIOException, NumberFormatException {
        println(prompt);
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public int readInt(String prompt, int min, int max) throws FlooringUserIOException, NumberFormatException {
        do {
            println(prompt);
            String input = sc.nextLine();
            try {
                if (input.compareTo(Integer.toString(min)) > -1
                        && input.compareTo(Integer.toString(max)) <= 0) {
                    int i = Integer.parseInt(input);
                    return i;
                }
            } catch (Exception e) {
            }
        } while (true);
    }

    @Override
    public int readIntEdit(String prompt, int min, int max) throws FlooringUserIOException, NumberFormatException {
        do {
            println(prompt);
            String input = sc.nextLine();
            try {
                if (input.isEmpty()) {
                    return -1;
                }
                if ((input.compareTo(Integer.toString(min)) > -1
                        && input.compareTo(Integer.toString(max)) <= 0)) {
                    int i = Integer.parseInt(input);
                    return i;
                }
            } catch (Exception e) {
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        long longVal = 0;
        Boolean keepGoing = true;
        do {
            try {
                println(prompt);
                String input = sc.nextLine();
                longVal = Long.parseLong(input);
                keepGoing = false;
            } catch (Exception e) {
                keepGoing = true;
            }
        } while (keepGoing);
        return longVal;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            println(prompt);
            String input = sc.nextLine();
            if (input.compareTo(Long.toString(min)) > -1
                    && input.compareTo(Long.toString(max)) <= 0
                    && !input.contains(".")) {
                long l = Integer.parseInt(input);
                return l;
            }
        } while (true);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public String readString(String prompt, int min, int max) {
        do {
            System.out.println(prompt);
            String input = sc.nextLine();
            if (!input.isEmpty()
                    && input.length() <= max
                    && input.length() >= min) {
                return input;
            }
        } while (true);
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        LocalDate date;
        Boolean keepGoing = true;
        do {
            System.out.println(prompt);
            String input = sc.nextLine();
            try {
                date = LocalDate.parse(input, DateTimeFormatter
                        .ofPattern("MM/dd/yy"));
                keepGoing = false;
                return date;
            } catch (Exception e) {
                keepGoing = true;
            }
        } while (keepGoing);
        return null;
    }
}
