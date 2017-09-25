/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.util.Random;

/**
 *
 * @author parallels
 */
public enum PetType {
    
    DOG,
    CAT,
    HAMSTER,
    GUINEA_PIG,
    CANARY,
    BOA_CONSTRICTOR;
    
    private static final Random random = new Random();
    private static final PetType[] values = PetType.values();
    
    public static PetType getRandom(){
        return values[random.nextInt(values.length)];
    }
}
