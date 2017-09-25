/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jstuart15
 */
public class StateCapitals {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        
        capitals.put("Arizona", "Phoenix");
        capitals.put("Minnesota", "St. Paul");
        capitals.put("California", "Sacramento");
        capitals.put("Alabama", "Montgomery");
        capitals.put("Alaska", "Juneau");
        capitals.put("Arkansas", "Little Rock");
        
        System.out.println("STATES");
        System.out.println("======");
        
        Set<String> keys = capitals.keySet();
        for(String k : keys){
            System.out.println(k);
        }
        
        System.out.println("\nCAPITALS");
        System.out.println("========");
        Collection<String> capitalValues = capitals.values();
        for (String cap : capitalValues){
            System.out.println(cap);
        }
        
        System.out.println("\nSTATE/CAPITAL PAIRS");
        System.out.println("=====================");
        for (String k : keys){
            System.out.println(k + " - " + capitals.get(k));
        }
        
        
        
        
    }
}
