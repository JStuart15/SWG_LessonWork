/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.controller;

import com.sg.messagetemplater.dao.GuestDao;
import com.sg.messagetemplater.dao.GuestDaoJsonFileImpl;
import com.sg.messagetemplater.model.Guest;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jstuart15
 */
@RestController
public class GuestController {

    private final GuestDao guestDao = new GuestDaoJsonFileImpl();

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public List<Guest> getAllGuests() {
        return guestDao.getAllGuests();
    }

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
    public Guest getGuest(@PathVariable("id") long id) {
        return guestDao.getGuestById(id);
    }
}
