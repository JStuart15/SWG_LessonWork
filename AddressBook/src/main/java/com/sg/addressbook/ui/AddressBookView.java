/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class AddressBookView {

    UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Remove Address");
        io.print("3. View number of addresses");
        io.print("4. List all addresses");
        io.print("5. Find address by last name");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.",
                1, 6);
    }

    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter first name");
        String lastName = io.readString("Please enter last name");
        String streetAddress = io.readString("Please enter street address");
        String city = io.readString("Please enter city");
        String state = io.readString("Please enter state");
        String zip = io.readString("Please enter zip code");

        Address currentAddress = new Address(firstName, lastName,
                streetAddress, city, state, zip); //TODO what happens if they send in a null for any of the values?

        return currentAddress;
    }

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Address succesfully created. Please hit enter to continue");
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getFirstName() + " "
                    + currentAddress.getLastName() + " "
                    + currentAddress.getStreetAddress() + " "
                    + currentAddress.getCity() + ", "
                    + currentAddress.getState() + " "
                    + currentAddress.getZip());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public String getLastName() {
        return io.readString("Please enter a last name to search");
    }

    public void displayAddress(Address address) {
        if (address != null){
            io.print(address.getFirstName() + " "
                + address.getLastName() + " "
                + address.getStreetAddress() + " "
                + address.getCity() + " "
                + address.getState() + " "
                + address.getZip());
        } else {
            io.print("No address entered for " + address.getLastName());
        }
        io.readString("Please hit enter to continue");
    }

    public void displayAddressBanner() {
        io.print("=== Display Address by Last Name ===");
    }
}
