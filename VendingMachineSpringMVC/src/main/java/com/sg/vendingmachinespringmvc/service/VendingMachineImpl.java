/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public Item getItem(int itemIdSelected) {
        return dao.getItem(itemIdSelected);
    }

    @Override
    public Map<String, String> completePurchase(String itemSelected, BigDecimal totalDeposit) {
        Map<String, String> purchaseResults = new HashMap<>();
        try {
            Change change = new Change();
            int itemIdSelected = Integer.parseInt(itemSelected);
            Item itemPurchased = dao.getItem(itemIdSelected);
            if (itemPurchased.getQuantityAvailable() > 0) {
                if (totalDeposit.compareTo(itemPurchased.getItemCost()) >= 0) {
                    itemPurchased.setQuantityAvailable(itemPurchased.getQuantityAvailable() - 1);
                    purchaseResults.put("success", "true");
                    purchaseResults.put("message", "Thank You!!!");
                    purchaseResults.put("changeMessage", change.makeChange(totalDeposit, itemPurchased.getItemCost()));

                } else {
                    purchaseResults.put("message",
                            "Please deposit: "
                            + itemPurchased.getItemCost().subtract(totalDeposit));
                }
            } else {
                purchaseResults.put("message", "SOLD OUT!!!");
            }
        } catch (Exception e) {
            purchaseResults.put("message", "Please select a product");
        }
        return purchaseResults;
    }
}
