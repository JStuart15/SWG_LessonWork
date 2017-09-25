/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

/**
 *
 * @author parallels
 */
public class Pet {
    
    private String name;
    private PetType petType;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the petType
     */
    public PetType getPetType() {
        return petType;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param petType the petType to set
     */
    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
