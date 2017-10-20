/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.time.LocalDateTime;

/**
 *
 * @author jstuart15
 */
public class Siting {
    private int sitingId;
    private int locationId;
    private LocalDateTime date;

    public int getSitingId() {
        return sitingId;
    }

    public void setSitingId(int sitingId) {
        this.sitingId = sitingId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
    
}
