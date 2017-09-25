/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.mapexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jstuart15
 */
public class MapExamples {

    public static void main(String[] args) {
        Map<String, Integer> populations = new HashMap<>();

        populations.put("USA", 200000000);
        populations.put("Canada", 34000000);
        populations.put("United Kingdom", 63000000);
        populations.put("Japan", 127000000);

        System.out.println("Map size is: " + populations.size());

        Integer usaPopulation = populations.get("USA");

        System.out.println(usaPopulation);

        //200M is not right, need to replace it
        populations.put("USA", 313000000); // there is only one USA key in there and it will replace what's there.

        usaPopulation = populations.get("USA");
        System.out.println(usaPopulation);

        //looping through hashmaps; get keys out and run through them to get associated values;
        Set<String> keys = populations.keySet(); // a set is not ordered

        for (String currentKey : keys) {
            Integer currentPopulation = populations.get(currentKey);
            System.out.println("The population of " + currentKey + " is " + currentPopulation);
        }

        //another way to do this is; more compact
        for (String k : keys) {
            System.out.println("The population of " + k + " is " + populations.get(k));
        }

        //Getting all values out of a map; in order to calculate min/max/avg
        Collection<Integer> populationValues = populations.values();

        for (Integer currentPopulation : populationValues) {
            System.out.println(currentPopulation);
        }

        Map<String, Integer> highestQuiz = new HashMap<>();
        highestQuiz.put("Jeff", 98);
        highestQuiz.put("Tristan", 45);
        highestQuiz.put("Travis", 99);

        for (String key : highestQuiz.keySet()) {
            int maxQuiz = highestQuiz.get(key);
            System.out.println(highestQuiz.get(key));
        }

    }

}
