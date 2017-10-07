/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jstuart15
 */
public class VendingMachineImpl implements VendingMachine {

    VendingMachineDao dao;

    @Inject
    VendingMachineImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

    public Item getItem(int itemIdSelected) {
        return dao.getItem(itemIdSelected);
    }

}
