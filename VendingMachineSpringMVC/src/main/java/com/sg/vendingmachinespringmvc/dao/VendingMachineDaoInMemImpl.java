/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    Map<Integer, Item> items = new HashMap<>();

    public VendingMachineDaoInMemImpl() {
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItemName("Snickers");
        item1.setItemCost(new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP));
        item1.setQuantityAvailable(9);
        items.put(1, item1);

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemName("M&Ms");
        item2.setItemCost(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        item2.setQuantityAvailable(2);
        items.put(2, item2);

        Item item3 = new Item();
        item3.setItemId(3);
        item3.setItemName("Almond Joy");
        item3.setItemCost(new BigDecimal(2.10).setScale(2, RoundingMode.HALF_UP));
        item3.setQuantityAvailable(5);
        items.put(3, item3);

        Item item4 = new Item();
        item4.setItemId(4);
        item4.setItemName("Reese's");
        item4.setItemCost(new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP));
        item4.setQuantityAvailable(4);
        items.put(4, item4);

        Item item5 = new Item();
        item5.setItemId(5);
        item5.setItemName("Milky Way");
        item5.setItemCost(new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP));
        item5.setQuantityAvailable(9);
        items.put(5, item5);

        Item item6 = new Item();
        item6.setItemId(6);
        item6.setItemName("Payday");
        item6.setItemCost(new BigDecimal(1.95).setScale(2, RoundingMode.HALF_UP));
        item6.setQuantityAvailable(3);
        items.put(6, item6);

        Item item7 = new Item();
        item7.setItemId(7);
        item7.setItemName("Doritos");
        item7.setItemCost(new BigDecimal(1.75).setScale(2, RoundingMode.HALF_UP));
        item7.setQuantityAvailable(11);
        items.put(7, item7);

        Item item8 = new Item();
        item8.setItemId(8);
        item8.setItemName("Pringles");
        item8.setItemCost(new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP));
        item8.setQuantityAvailable(0);
        items.put(8, item8);

        Item item9 = new Item();
        item9.setItemId(9);
        item9.setItemName("Cheezits");
        item9.setItemCost(new BigDecimal(1.95).setScale(2, RoundingMode.HALF_UP));
        item9.setQuantityAvailable(6);
        items.put(9, item9);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public Item getItem(int itemId) {
        return items.get(itemId);
    }

    @Override
    public void updateItem(Item item) {
        items.put(item.getItemId(), item);
    }
}
