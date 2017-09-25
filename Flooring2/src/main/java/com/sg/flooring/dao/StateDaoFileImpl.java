/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class StateDaoFileImpl implements StateDao {

    public static final String STATE_FILE = "states.txt";
    public static final String DELIMETER = ",";

    Map<String, BigDecimal> states = new HashMap<>();

    @Override
    public Map<String, BigDecimal> getAllStates() throws FlooringPersistenceException {
        loadStates();
        return states;
    }

    private void loadStates() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(STATE_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load dvd library into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            states.put(currentTokens[0].toUpperCase(), new BigDecimal(currentTokens[1]));
        }
        scanner.close();
    }

}
