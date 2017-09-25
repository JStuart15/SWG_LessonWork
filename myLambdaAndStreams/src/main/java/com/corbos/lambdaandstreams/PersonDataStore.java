/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author parallels
 */
public class PersonDataStore extends FileDataStore {

    private final Random random = new Random();

    public List<Person> all() throws IOException {
        ArrayList<Person> result = new ArrayList<>();

        PetDataStore petStore = new PetDataStore();

        runPerRecord("people.csv", items -> {

            Person p = new Person();
            p.setId(Integer.parseInt(items[0]));
            p.setFirstName(items[1]);
            p.setLastName(items[2]);
            p.setEmailAddress(items[3]);
            p.setGender(items[4]);
            p.setCountry(items[5]);
            p.setBuzzWord(items[6]);
            IntStream.range(0, random.nextInt(4))
                    .forEach(i -> p.addPet(petStore.getRandom()));

            result.add(p);
        });

        return result;
    }
}
