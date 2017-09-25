/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.controller;

import com.sg.homeinventory.dao.HomeInventoryPersistenceException;
import com.sg.homeinventory.service.HomeInventoryDataValidationException;

import com.sg.homeinventory.dto.Item;
import com.sg.homeinventory.service.HomeInventoryDuplicateIdException;
import com.sg.homeinventory.ui.HomeInventoryView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sg.homeinventory.service.HomeInventoryServiceLayer;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryController {

    //private HomeInventoryView view = new HomeInventoryView();
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    HomeInventoryView view;
    HomeInventoryServiceLayer service;

    public HomeInventoryController(HomeInventoryServiceLayer service, HomeInventoryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        createItem();
                        break;
                    case 3:
                        viewItem();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (HomeInventoryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (HomeInventoryDuplicateIdException ex) {
            view.displayErrorMessage(ex.getMessage());
        } catch (HomeInventoryDataValidationException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void removeItem() throws HomeInventoryPersistenceException {
        view.displayRemovedItemBanner();
        String itemNumber = view.getItemIdChoice();
        service.removeItem(itemNumber);
        view.displayRemovedItemSuccessBanner();
    }

    private void viewItem() throws HomeInventoryPersistenceException {
        view.displayDisplayItemBanner();
        view.displayItem(service.getItem(view.getItemIdChoice()));
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createItem() throws HomeInventoryPersistenceException,
            HomeInventoryDuplicateIdException,
            HomeInventoryDataValidationException {
        view.displayCreateItemBanner();
        boolean hasErrors = false;
        do {
            Item currentItem = view.getNewItemInfo();
            try {
                service.createItem(currentItem);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (HomeInventoryDuplicateIdException | HomeInventoryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            } catch (NumberFormatException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listItems() throws HomeInventoryPersistenceException {
        view.displayDisplayAllBanner();
        List<Item> itemList = service.getAllItems();
        view.displayItemList(itemList);

    }
}
