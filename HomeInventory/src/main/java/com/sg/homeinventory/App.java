package com.sg.homeinventory;

import com.sg.homeinventory.controller.HomeInventoryController;
import com.sg.homeinventory.dao.HomeInventoryAuditDaoFileImpl;
import com.sg.homeinventory.dao.HomeInventoryDaoFileImpl;
import com.sg.homeinventory.service.HomeInventoryServiceLayerImpl;
import com.sg.homeinventory.ui.HomeInventoryView;
import com.sg.homeinventory.ui.UserIO;
import com.sg.homeinventory.ui.UserIOConsoleImpl;
import com.sg.homeinventory.dao.HomeInventoryAuditDao;
import com.sg.homeinventory.dao.HomeInventoryDao;
import com.sg.homeinventory.service.HomeInventoryServiceLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        HomeInventoryView myView = new HomeInventoryView(myIo);
        HomeInventoryDao myDao = new HomeInventoryDaoFileImpl();
        HomeInventoryAuditDao myAuditDao = new HomeInventoryAuditDaoFileImpl();
        HomeInventoryServiceLayer myService = new HomeInventoryServiceLayerImpl(myDao, myAuditDao);
        HomeInventoryController controller = new HomeInventoryController(myService, myView);
        controller.run();
    }
}
