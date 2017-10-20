/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class Sighting {
    private int sightingId;
    private int locationId;
    private LocalDateTime date;
    private List<SuperPeople> superPeople;

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
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

    public List<SuperPeople> getSuperPeople() {
        return superPeople;
    }

    public void setSuperPeople(List<SuperPeople> superPeople) {
        this.superPeople = superPeople;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.sightingId;
        hash = 43 * hash + this.locationId;
        hash = 43 * hash + Objects.hashCode(this.date);
        hash = 43 * hash + Objects.hashCode(this.superPeople);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.superPeople, other.superPeople)) {
            return false;
        }
        return true;
    }
    
    
}
