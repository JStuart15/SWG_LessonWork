/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface VendingMachine {
    public List<Item> getAllItems();

    public Item getItem(int itemIdSelected);
}
