/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item item1;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        //add dummy item data so that when instantiated it will have items in memory
        item1 = new Item();
        item1.setItemId(1);
        item1.setItemName("Beef Jerky");
        item1.setItemCost(new BigDecimal("1.50"));
        item1.setQuantityAvailable(1);
        itemList.add(item1);
    }
    @Override
    public List<Item> getAllItems() {
        return itemList;
    }

    @Override
    public Item getItem(int itemId) {
        if(itemId == item1.getItemId()){
            return item1;
        } else {
            return null;
        }
    }

    @Override
    public void updateItem(Item item) {
        item1.setItemCost(item.getItemCost());
        item1.setItemName(item.getItemName());
        item1.setQuantityAvailable(item.getQuantityAvailable());
        
        itemList.add(item1);
    }
    
}
