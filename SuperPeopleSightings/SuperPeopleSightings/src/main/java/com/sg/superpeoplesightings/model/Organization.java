/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jstuart15
 */
public class Organization {

    private int organizationId;

    @NotEmpty(message = "You must enter a value for organization name.")
    @Length(max = 45, message = "Organization name cannot be longer than 45 characters in length.")
    private String name;

    @Length(max = 45, message = "Description cannot be longer than 45 characters in length.")
    private String description;

    @Length(max = 45, message = "Street cannot be longer than 45 characters in length.")
    private String street;

    @Length(max = 45, message = "City cannot be longer than 45 characters in length.")
    private String city;

    @Length(max = 2, message = "State cannot be longer than 2 characters in length.")
    private String state;

    @Length(max = 10, message = "Zip code cannot be longer than 10 characters in length.")
    private String zip;

    @Length(max = 12, message = "Phone cannot be longer than 12 characters in length.")
    private String phone;

    private Boolean isActive;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.organizationId;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.street);
        hash = 61 * hash + Objects.hashCode(this.city);
        hash = 61 * hash + Objects.hashCode(this.state);
        hash = 61 * hash + Objects.hashCode(this.zip);
        hash = 61 * hash + Objects.hashCode(this.phone);
        hash = 61 * hash + Objects.hashCode(this.isActive);
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.isActive, other.isActive)) {
            return false;
        }
        return true;
    }

}
