/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.ui;

import java.time.LocalDate;

/**
 *
 * @author jstuart15
 */
public interface UserIO {

    void println(String message);

    void print(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt) throws FlooringUserIOException, NumberFormatException;

    int readInt(String prompt, int min, int max) throws FlooringUserIOException, NumberFormatException;

    int readIntEdit(String prompt, int min, int max) throws FlooringUserIOException, NumberFormatException;

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);

    String readString(String prompt, int min, int max);

    public LocalDate readLocalDate(String prompt);
}
