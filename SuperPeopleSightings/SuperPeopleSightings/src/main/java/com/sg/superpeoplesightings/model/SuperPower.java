/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class SuperPower {

    private int superPowerId;
    private String description;
    private Boolean isActive;

    public int getSuperPowerId() {
        return superPowerId;
    }

    public void setSuperPowerId(int superPowerId) {
        this.superPowerId = superPowerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.superPowerId;
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.isActive);
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
        final SuperPower other = (SuperPower) obj;
        if (this.superPowerId != other.superPowerId) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.isActive, other.isActive)) {
            return false;
        }
        return true;
    }

}
