/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class Organization {

    private int organizationId;
    private String name;
    private List<SuperPeople> superPeople;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuperPeople> getSuperPeople() {
        return superPeople;
    }

    public void setSuperPeople(List<SuperPeople> superPeople) {
        this.superPeople = superPeople;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.organizationId;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.superPeople);
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
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.superPeople, other.superPeople)) {
            return false;
        }
        return true;
    }

    

}
