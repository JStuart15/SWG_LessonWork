/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface AddressBookDao {

    /**
     * Adds address to the address book. 
     *
     * @param Address object
     * @return boolean for success or fail
     */
    boolean addAddress(Address address);

    /**
     * Removes address from the address book.
     *
     * @param String lastName
     * @return boolean for success or fail
     */
    Address removeAddress(String lastName);

    /**
     * Gets address by last name.
     *
     * @param String lastName
     * @return boolean for success of fail
     */
    Address getAddressByLastName(String lastName);

    /**
     * Gets address count
     * 
     * @param none
     * @return integer
     */
    int getAddressCount();
    
    /**
     * Lists all addresses in the address book.
     * 
     * @param none
     * @return list of address objects
     */
    List<Address> getAllAddresses();
}
