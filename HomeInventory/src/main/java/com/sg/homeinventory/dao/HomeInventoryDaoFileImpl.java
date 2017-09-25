/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.dao;

import com.sg.homeinventory.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryDaoFileImpl implements HomeInventoryDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMETER = "::";

    private Map<String, Item> items = new HashMap<>();

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.  Overwrites any file that is there.
     *
     * @throws HomeInventoryPersistenceException if an error occurs writing to the file
     */
    private void writeRoster() throws HomeInventoryPersistenceException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new HomeInventoryPersistenceException("-_- Could not save item data.", e);
        }

        // Write out the Item objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            //write the Item object to the file
            out.println(currentItem.getItemNumber() + DELIMETER
                    + currentItem.getName() + DELIMETER
                    + currentItem.getDescription() + DELIMETER
                    + currentItem.getCost());
            //force PrintWriter to write currentStudent to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

    private void loadRoster() throws HomeInventoryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new HomeInventoryPersistenceException("-_- Could not load roster data into memory.", e);
        }

        //currentLine holds the most recent line read from the file
        String currentLine;

        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMETER
        String[] currentTokens;

        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Item object.  Process while we have more lines in the file.
        while (scanner.hasNextLine()) {
            //get the next line in the file
            currentLine = scanner.nextLine();
            //break up the line into tokens
            currentTokens = currentLine.split(DELIMETER);
            //create a new Item object and put it into the map of students
            Item currentItem = new Item(currentTokens[0]);
            //Set the remaining values on currentStudent manually
            currentItem.setName(currentTokens[1]);
            currentItem.setDescription(currentTokens[2]);
            currentItem.setCost(currentTokens[3]);

            //put currentStudent into the map using studentID as the key
            items.put(currentItem.getItemNumber(), currentItem);
        }
        //close scanner
        scanner.close();
    }

    @Override
    public Item addItem(String itemNumber, Item item)
            throws HomeInventoryPersistenceException {
        Item newItem = items.put(itemNumber, item);
        writeRoster();
        return newItem;
    }

    @Override
    public List<Item> getAllItems() throws HomeInventoryPersistenceException {
        loadRoster();
        return new ArrayList<Item>(items.values());//was a hash map, this converts to ArrayList;
    }

    @Override
    public Item getItem(String itemNumber) throws HomeInventoryPersistenceException {
        loadRoster();
        return items.get(itemNumber);
    }

    @Override
    public Item removeItem(String studentId) throws HomeInventoryPersistenceException {
        Item removedStudent = items.remove(studentId);
        writeRoster();
        return removedStudent;
    }

}
