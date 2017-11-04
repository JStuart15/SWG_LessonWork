/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.oct32017warmup;

/**
 *
 * @author jstuart15
 */
public class Main {
    public static void main(String[] args) {
        String json="{"
                + "id: 57,"
                + "name: 'The hellfire club',"
                + "created: '1985-11-03',"
                + "location: {"
                + "city: 'St. Paul',"
                + "state: 'MN',"
                + "zip: 55555"
                + "}"
                + "};";
        
        Organization org = new Organization();
        Location loc = new Location();
        
        char[] jsonChar = json.toCharArray();
        json.charAt(0);
        json.t
        for (char c : jsonChar) {
            
        }
        System.out.println(json.indexOf('{'));
        System.out.println(json.indexOf('}'));
    }
}
