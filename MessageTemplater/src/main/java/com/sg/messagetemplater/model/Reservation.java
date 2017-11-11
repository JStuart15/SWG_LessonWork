/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.model;

import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class Reservation {

    private String roomNumber;
    private long startTimestamp;
    private long endTimestamp;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.roomNumber);
        hash = 97 * hash + (int) (this.startTimestamp ^ (this.startTimestamp >>> 32));
        hash = 97 * hash + (int) (this.endTimestamp ^ (this.endTimestamp >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.startTimestamp != other.startTimestamp) {
            return false;
        }
        if (this.endTimestamp != other.endTimestamp) {
            return false;
        }
        if (!Objects.equals(this.roomNumber, other.roomNumber)) {
            return false;
        }
        return true;
    }
}
