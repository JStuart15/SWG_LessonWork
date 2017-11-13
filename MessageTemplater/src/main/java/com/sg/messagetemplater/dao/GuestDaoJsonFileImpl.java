/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.messagetemplater.model.Guest;
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
    public List<Guest> getAllGuests() {
        loadGuests();
        return guestList;
    }

    @Override
    public Guest getGuestById(long id) {
        loadGuests();
        for (Guest guest : guestList) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null;
    }

    private void loadGuests() {
        File fileName = new File("Guests.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            guestList = mapper.readValue(fileName,
                    new TypeReference<List<Guest>>() {
            });
        } catch (Exception e) {
            System.out.println("Error getting guest from file: " + e.getMessage());
        }
    }
}
