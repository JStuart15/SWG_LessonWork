/*
 * To changeMessage this license header, choose License Headers in Project Properties.
 * To changeMessage this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachine;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class VendingMachineController {

    Change change;
    //VendingMachineDao dao;
    VendingMachine service;
    String itemSelected;
    BigDecimal totalIn = new BigDecimal(0);
    String message;
    String changeMessage;
    Boolean madePurchase = false;
    List<Item> itemList = new ArrayList<>();

    @Inject
    public VendingMachineController(VendingMachine service) {
        this.service = service; 
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(Model model) {
        itemList = service.getAllItems();
        model.addAttribute("itemList", itemList);
        model.addAttribute("itemSelected", itemSelected);
        model.addAttribute("totalIn", totalIn.setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("message", message);
        model.addAttribute("changeMessage", changeMessage);
        return "index";
    }

    @RequestMapping(value = "/updateItemSelected", method = RequestMethod.POST)
    public String updateItemSelected(HttpServletRequest request) {
        message = "";
        changeMessage = "";
        itemSelected = request.getParameter("itemId");
        return "redirect:/";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public String addMoney(HttpServletRequest request) {
        String moneyIn = request.getParameter("denom");
        totalIn = new BigDecimal(moneyIn).add(totalIn);
        message = "";
        changeMessage = "";
        return "redirect:/";
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String returnChange() {
        changeMessage = change.makeChange(totalIn, new BigDecimal(0));
        itemSelected = "";
        message = "";
        totalIn = new BigDecimal(0);
        return "redirect:/";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase() {
        try {
            int itemIdSelected = Integer.parseInt(itemSelected);
            Item itemPurchased = service.getItem(itemIdSelected);
            if (itemPurchased.getQuantityAvailable() > 0) {
                if (totalIn.compareTo(itemPurchased.getItemCost()) >= 0) {
                    itemPurchased.setQuantityAvailable(itemPurchased.getQuantityAvailable() - 1);
                    message = "Thank You!!!";
                    changeMessage = change.makeChange(totalIn, itemPurchased.getItemCost());
                    itemSelected = "";
                    totalIn = new BigDecimal(0);
                } else {
                    message = "Please deposit: " + itemPurchased.getItemCost().subtract(totalIn);
                }
            } else {
                message = "SOLD OUT!!!";
            }
        } catch (Exception e) {
            message = "Please select a product";
        }
        return "redirect:/";
    }
}
