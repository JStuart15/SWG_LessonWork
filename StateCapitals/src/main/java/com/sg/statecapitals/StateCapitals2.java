/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jstuart15
 */
public class StateCapitals2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Capital> capitals = new HashMap<>();

        capitals.put("Alabama", new Capital("Montgomery", 205000, 156));
        capitals.put("Alaska", new Capital("Juneau", 31000, 3255));
        capitals.put("Arizona", new Capital("Phoenix", 1445000, 517));
        capitals.put("Arkansas", new Capital("Little Rock", 193000, 116));

        System.out.println("STATE/CAPITAL PAIRS");
        System.out.println("===================");

        Set<String> keys = capitals.keySet();
        for (String k : keys) {
            System.out.println(k + " - " + capitals.get(k).getName()
                    + " | Pop: " + capitals.get(k).getPopulation()
                    + " | Area: " + capitals.get(k).getSquareMileage());
        }

        System.out.println("\nPlease enter the lower limit for capital city population: ");
        int ll = sc.nextInt();
        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN " + ll);
        for (String k : keys) {
            if (capitals.get(k).getPopulation() > ll) {
                System.out.println(k + " - " + capitals.get(k).getName()
                        + " | Pop: " + capitals.get(k).getPopulation()
                        + " | Area: " + capitals.get(k).getSquareMileage());
            }
        }
    }

}
