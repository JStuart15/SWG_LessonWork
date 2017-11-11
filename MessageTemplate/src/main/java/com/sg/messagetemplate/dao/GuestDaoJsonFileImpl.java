/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplate.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.messagetemplate.model.Guest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class GuestDaoJsonFileImpl implements GuestDao {

    private List<Guest> guestList = new ArrayList<>();

    @Override
    public Guest addGuest(Guest company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Guest> getAllGuests() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File fileName = new File("Guests.json");
            guestList = mapper.readValue(fileName,
                    new TypeReference<List<Guest>>() {
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return guestList;
    }

    @Override
    public Guest getGuestById(long companyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
