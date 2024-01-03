package com.my.datastrcture.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateIntegerInList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Set<Integer> sets = new HashSet<>();

        list.stream().filter(val -> sets.add(val) == false ).forEach(System.out::println);
    }
}
