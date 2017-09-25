/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class AddressBookController {

    private UserIO io = new UserIOConsoleImpl();
    private AddressBookView view = new AddressBookView();
    private AddressBookDao dao = new AddressBookDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    io.print("REMOVE ADDRESS");
                    break;
                case 3:
                    io.print("VIEW COUNT OF ADDRESSES");
                    break;
                case 4:
                    listAddresses();
                    break;
                case 5:
                    findAddressByLastName();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOOD BYE");
    }

    private void findAddressByLastName() {
        String lastName = view.getLastName();
        view.displayAddressBanner();
        view.displayAddress(dao.getAddressByLastName(view.getLastName()));
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }
}
