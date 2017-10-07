/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface VendingMachineDao {

    List<Item> getAllItems();

    public Item getItem(int itemId);

    public void updateItem(Item item);
}
