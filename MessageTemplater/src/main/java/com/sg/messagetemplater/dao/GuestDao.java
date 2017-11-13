/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.dao;

import com.sg.messagetemplater.model.Guest;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface GuestDao {

    public List<Guest> getAllGuests();

    public Guest getGuestById(long id);

}
