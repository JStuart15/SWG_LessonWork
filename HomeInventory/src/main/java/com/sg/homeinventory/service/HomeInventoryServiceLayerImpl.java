/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.service;

import com.sg.homeinventory.dao.HomeInventoryPersistenceException;
import com.sg.homeinventory.dto.Item;
import java.util.List;
import com.sg.homeinventory.dao.HomeInventoryAuditDao;
import com.sg.homeinventory.dao.HomeInventoryDao;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryServiceLayerImpl implements HomeInventoryServiceLayer {

    HomeInventoryDao dao;
    private HomeInventoryAuditDao auditDao;

    public HomeInventoryServiceLayerImpl(HomeInventoryDao dao, HomeInventoryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createItem(Item item) throws
            HomeInventoryDuplicateIdException,
            HomeInventoryDataValidationException,
            HomeInventoryPersistenceException {

        if (dao.getItem(item.getItemNumber()) != null) {
            throw new HomeInventoryDuplicateIdException(
                    "ERROR: Could not create item. Item number "
                    + item.getItemNumber()
                    + " already exists");
        }

        if (item.getCost().contains("$")) {
            String newCost = item.getCost().replace("$", "");
            item.setCost(newCost);
        }
        trimEntryFields(item);

        validateItemData(item);

        try{
            isProperNumber(item);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
            "ERROR: Could not create item. The cost "+ item.getCost() + " is invalid.");
        }
        
        dao.addItem(item.getItemNumber(), item);

        auditDao.writeAuditEntry(
                "Item " + item.getItemNumber() + " CREATED.");

    }

    @Override
    public List<Item> getAllItems() throws
            HomeInventoryPersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemNumber) throws
            HomeInventoryPersistenceException {
        return dao.getItem(itemNumber);
    }

    @Override
    public Item removeItem(String itemNumber) throws
            HomeInventoryPersistenceException {
        auditDao.writeAuditEntry("Student " + itemNumber + " REMOVED.");
        return dao.removeItem(itemNumber);
    }

    private void isProperNumber (Item item) throws NumberFormatException {
        Double.parseDouble(item.getCost());
    }
    
    private void validateItemData(Item item) throws
            HomeInventoryDataValidationException {
        if (item.getName() == null
                || item.getName().trim().length() == 0
                || item.getDescription() == null
                || item.getDescription().trim().length() == 0
                || item.getCost() == null
                || item.getCost().trim().length() == 0) {
            throw new HomeInventoryDataValidationException(
                    "ERROR: All fields [Item Name, Description, Cost] are required.");
        }
    }

    private Item trimEntryFields(Item item) {
        item.setItemNumber(item.getItemNumber().trim());
        item.setName(item.getName().trim());
        item.setDescription(item.getDescription().trim());
        item.setCost(item.getCost().trim());

        return item;
    }
}
