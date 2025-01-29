package com.my.datastrcture.interview;

import java.util.*;
import java.util.stream.Collectors;

/*
* Map<String,Person> map = new HashMap<>();
map.put("g",new Person(5, 51, "EE"));
map.put("e",new Person(4,25,"DD"));
map.put("a",new Person(3, 44, "CC"));
*
* Can I sort the map base on age like
 Map<String,Person> map = new HashMap<>();
map.put("e",new Person(4,25,"DD"));
map.put("a",new Person(3, 44, "CC"));
map.put("g",new Person(5, 51, "EE"));
*
* */

public class StreamMapMain {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();
        map.put("g", new Person(5, 51, "EE"));
        map.put("e", new Person(4, 25, "DD"));
        map.put("a", new Person(3, 44, "CC"));


        // Fix: Collect into LinkedHashMap
        Map<String, Person> newMap = map.entrySet().stream()
                .sorted(Comparator.comparing(m -> m.getValue().getAge()))
                //.sorted(Comparator.comparing((Map.Entry<String, Person> m) -> m.getValue().getAge()).reversed())
                //.sorted((entry1, entry2) -> Integer.compare(entry2.getValue().getAge(), entry1
                // .getValue().getAge()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate keys
                        LinkedHashMap::new // Maintain order
                ));

        //newMap.forEach((s, person) -> System.out.println( s +" -> "+person));
        System.out.println(newMap);
        System.out.println();

        sortMap(map);
        System.out.println();
        sortMapDescendingOrder(map);
        System.out.println();
        sortMapDescendingOrderWithoutReverse(map);
    }

    private static void sortMap(Map<String, Person> map) {
        Map<String, Person> sortedMap = map.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry1.getValue().getAge(), entry2.getValue().getAge()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate keys
                        LinkedHashMap::new // Maintain insertion order for sorted entries
                ));

        sortedMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }


    private static void sortMapUsingComparable(Map<String, Person> map){

        // Create a list of map entries
        List<Map.Entry<String, Person>> entryList = new ArrayList<>(map.entrySet());

        // Sort using the natural ordering of Person (Comparable)
        entryList.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to maintain sorted order
        Map<String, Person> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Person> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }


    private static void sortMapDescendingOrder(Map<String, Person> map){
        Map<String, Person> newMap = map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Person> m) -> m.getValue().getAge()).reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate keys
                        LinkedHashMap::new // Maintain order
                ));

        newMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void sortMapDescendingOrderWithoutReverse(Map<String, Person> map){
        Map<String, Person> newMap = map.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().getAge(), entry1.getValue().getAge()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate keys
                        LinkedHashMap::new // Maintain order
                ));

        Map<String, Person> sortedMap = map.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry1.getValue().getAge(), entry2.getValue().getAge()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate keys
                        LinkedHashMap::new // Maintain insertion order for sorted entries
                ));

        newMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
