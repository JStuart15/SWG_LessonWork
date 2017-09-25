/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.service;

import com.sg.homeinventory.dao.HomeInventoryPersistenceException;
import com.sg.homeinventory.dto.Item;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface HomeInventoryServiceLayer {
    
    void createItem (Item item) throws
            HomeInventoryDuplicateIdException,
            HomeInventoryDataValidationException,
            HomeInventoryPersistenceException;
    
    List<Item> getAllItems() throws
            HomeInventoryPersistenceException;
    
    Item getItem (String itemNumber) throws
            HomeInventoryPersistenceException;
    
    Item removeItem (String itemNumber) throws
            HomeInventoryPersistenceException;
}
