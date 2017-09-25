/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author parallels
 */
public class Main {

    public static void main(String[] args) throws IOException {

        PersonDataStore dataStore = new PersonDataStore();
        List<Person> people = dataStore.all();

//PEOPLE WITH LAST NAME STARTING WITH 'M'
//        people.stream()
//                .filter(p -> p.getLastName().startsWith("W"))
//                .forEach(Main::print);
        
//PEOPLE ORDERED BY LAST NAME DESCENDING
//        people.stream()
//                .sorted((n1, n2) -> {
//                    return n2.getLastName().compareTo(n1.getLastName());
//                })
//                .forEach(p -> {
//                    System.out.println(p.getLastName() + " "
//                            + p.getFirstName() + " "
//                            + p.getEmailAddress());
//                });
//
//People ordered by last name, then first name
//        people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
//                .forEach(p -> {
//                    System.out.println(p.getLastName() + " "
//                            + p.getFirstName() + " "
//                            + p.getEmailAddress());
//                });

//Group people by Country
//        people.stream()
//                .collect(Collectors.groupingBy((p) -> p.getCountry()))
//                .forEach(person -> {
//                    System.out.println();
//                });
//        
//Determine the min/max length of a last name per country
//        people.stream()
//                .collect(Collectors.groupingBy((p) -> p.getCountry())).forEach((k,v) -> {
//                Optional<Integer> min = v.stream()
//                        .map((p) -> p.getLastName().length()).min(Comparator.comparing((i)->i));
//                Optional<Integer> max = v.stream()
//                        .map((p) -> p.getLastName().length()).max(Comparator.comparing((i)->i));
//                System.out.println(k + " Min: " + min + "Max: " + max.toString());
//                });

//without a nested loop, print all pet names who are boa constrictors (see .flatMap)
//        people.stream()
//                .flatMap((p) -> p.getPets()
//                .stream()
//                .filter((pet) -> pet.getPetType() == PetType.BOA_CONSTRICTOR))
//                .forEach((pet) -> {
//                    System.out.println(pet.getName() + " " + pet.getPetType());
//                });
        //Most used email extension per country e.g. .edu, .com
//        people.stream()
//                .collect(Collectors.groupingBy((p) -> p.getCountry()))
//                .forEach((country, locals) -> {
//                Map<String, List<Person>> emailExt = locals.stream()
//                        .collect(Collectors.groupingBy(((l) -> l.getEmailAddress()
//                        .substring(l.getEmailAddress().lastIndexOf(".")))));
//                
//                int max = 0;
//                String maxKey = "";
//                for (String key : emailExt.keySet()){
//                    if(emailExt.get(key).size() > max ){
//                        maxKey = key;
//                    }
//                }
//                System.out.println(country + " most used email ext " + maxKey);
//                });
        //Average # of buzzwords per country
        //All people with multiple types of pets
        // People from Russia (or any other country starting with "Ru").        
        //        people.stream()
        //                .filter(p -> p.getCountry().startsWith("Ru"))
        //                .forEach(Main::print);
        //        Function<Person, Character> func = p -> p.getFirstName().charAt(0);
        //
        //        Map<Character, Double> result = people.stream()
        //                .collect(Collectors.groupingBy(
        //                        func,
        //                        Collectors.averagingInt(p -> p.getPets().size())
        //                ));
        //
        //        for (Character key : result.keySet()) {
        //            System.out.println(key + ": " + result.get(key));
        //        }
        //        people.stream()
        //                .map(p -> new GenericInterface() {
        //                    String personName = p.getFirstName() + " " + p.getLastName();
        //                    String pets = String.join(",", p.getPets().stream().map(pet -> pet.getName()).collect(Collectors.toList()));                    
        //                })
        //                .forEach(i -> System.out.printf("%s\n%s\n", i.personName, i.pets));
    }

    public static void print(Person p) {
        System.out.printf("%s: %s %s, %s", p.getCountry(), p.getFirstName(), p.getLastName(), p.getEmailAddress());
        System.out.println("");
    }
}

interface GenericInterface {
}
