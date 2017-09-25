/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.ui;

import com.sg.homeinventory.dto.Item;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryView {

    //UserIO io = new UserIOConsoleImpl();
    private UserIO io;

    public HomeInventoryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Item Numbers");
        io.print("2. Create New Item");
        io.print("3. View an Item");
        io.print("4. Remove an Item");
        io.print("5. Exit");
        return io.readInt("Please select from the above choices.",
                1, 5);
    }

    public void displayErrorMessage(String errorMsg){
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }

    public String getItemIdChoice() {
        return io.readString("Please enter Item Number");
    }

    public void displayItem(Item item) {
        if (item != null) {
            io.print(item.getItemNumber());
            io.print(item.getName() + " " + item.getDescription());
            io.print(item.getCost());
            io.print("");
        } else {
            io.print("No such item");
        }
        io.readString("Please hit enter to continue.");
    }

    public Item getNewItemInfo() {
        String itemNumber = io.readString("Please enter item number");
        String name = io.readString("Please enter item name");
        String description = io.readString("Please enter item description");
        String cost = io.readString("Please enter the cost.");

        Item currentItem = new Item(itemNumber);
        currentItem.setName(name);
        currentItem.setDescription(description);
        currentItem.setCost(cost);

        return currentItem;
    }

    public void displayRemovedItemBanner() {
        io.print("=== Remove Item ===");
    }

    public void displayRemovedItemSuccessBanner() {
        io.readString("Item successfully removed. Please hit enter to continue.");
    }

    public void displayCreateItemBanner() {
        io.print("=== Create Item ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Item succesfully created. Please hit enter to continue");
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getItemNumber() + ": "
                    + currentItem.getName() + "\n"
                    + "\t" + currentItem.getDescription() + "\n"
                    + "\t" + "$" + currentItem.getCost());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }
}
