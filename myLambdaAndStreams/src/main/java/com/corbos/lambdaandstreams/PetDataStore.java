/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parallels
 */
public class PetDataStore extends FileDataStore {    
    
    private ArrayList<String> names;
    private final Random random = new Random();
    
    public Pet getRandom() {
        if (names == null) {
            init();
        }
        Pet p = new Pet();
        p.setName(names.get(random.nextInt(names.size())));
        p.setPetType(PetType.getRandom());
        return p;
    }
    
    private void init() {
        try {
            names = new ArrayList<>();
            runPerRecord("pets.csv", items -> {
                names.add(items[0]);
            });
        } catch (IOException ex) {
            Logger.getLogger(PetDataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
