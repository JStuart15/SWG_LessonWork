/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    List<Address> addresses = new ArrayList<>();

    @Override
    public boolean addAddress(Address address) {
        return addresses.add(address);
    }

    @Override
    public Address removeAddress(String lastName) {
        Address removedAddress = addresses.
    }

    @Override
    public Address getAddressByLastName(String lastName) {
        Address retVal = new Address();
        int addressIndex = -1;
        for (Address address : addresses) {
            if (address.getLastName().equals(lastName)) {
                retVal = address;
            } else {
                retVal = null;
            }
        }
        return retVal;
    }

    @Override
    public int getAddressCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllAddresses() {
        return addresses;
    }

}
