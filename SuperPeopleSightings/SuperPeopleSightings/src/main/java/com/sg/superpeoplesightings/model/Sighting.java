/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class Sighting {
    private int sightingId;
    private Location location;
    private LocalDate date;
    private Date displayDate;
    private List<SuperPerson> superPeople;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.sightingId;
        hash = 17 * hash + Objects.hashCode(this.location);
        hash = 17 * hash + Objects.hashCode(this.date);
        hash = 17 * hash + Objects.hashCode(this.displayDate);
        hash = 17 * hash + Objects.hashCode(this.superPeople);
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
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.displayDate, other.displayDate)) {
            return false;
        }
        if (!Objects.equals(this.superPeople, other.superPeople)) {
            return false;
        }
        return true;
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(Date displayDate) {
        this.displayDate = displayDate;
    }

    public List<SuperPerson> getSuperPeople() {
        return superPeople;
    }

    public void setSuperPeople(List<SuperPerson> superPeople) {
        this.superPeople = superPeople;
    }
}
