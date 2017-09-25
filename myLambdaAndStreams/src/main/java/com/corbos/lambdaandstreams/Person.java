/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parallels
 */
public class Person {
    
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String gender;
    private String country;
    private String buzzWord;
    private final List<Pet> pets = new ArrayList<>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the buzzWord
     */
    public String getBuzzWord() {
        return buzzWord;
    }

    /**
     * @param buzzWord the buzzWord to set
     */
    public void setBuzzWord(String buzzWord) {
        this.buzzWord = buzzWord;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s,%s,%s,%s,%s", getFirstName(), getLastName(), getEmailAddress(), getGender(), getCountry(), getBuzzWord());
    }

    /**
     * @return the pets
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * @param pet
     */
    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
}
