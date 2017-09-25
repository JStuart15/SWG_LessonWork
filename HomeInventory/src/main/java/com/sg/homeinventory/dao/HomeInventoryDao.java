/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.dao;

import com.sg.homeinventory.dto.Item;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface HomeInventoryDao {

    /**
     * Adds the given Item to the roster and associates it with the given
 student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Item object previously associated with the given student
 id if it exists, null otherwise
     */
    Item addItem(String itemNumber, Item item) throws HomeInventoryPersistenceException;

    /**
     * Returns a String array containing the student ids of all students in the
     * roster.
     *
     * @return String array containing the ids of all the students in the roster
     */
    List<Item> getAllItems() throws HomeInventoryPersistenceException;

    /**
     * Returns the student object associated with the given student id. Returns
     * null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Item object associated with the given student id, null if
 no such student exists
     */
    Item getItem(String itemNumber) throws HomeInventoryPersistenceException;

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the student object that is being removed or null if there is no student
     * associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Item object that was removed or null if no student was
 associated with the given student id
     */
    Item removeItem(String itemNumber) throws HomeInventoryPersistenceException;
}
