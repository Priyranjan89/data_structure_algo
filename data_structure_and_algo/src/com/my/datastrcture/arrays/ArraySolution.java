package com.my.datastrcture.arrays;
/*
* arr = [b,b,c,d,d,a,a,b,b,c,c,d,a]

 Given an array of characters , find the min length sub-array within this array
 which has all the unique elements present in the array.

 unique = [b,c,d,a]

 write a function which accepts the given char array as input and prints i,j index of the min length sub-array.
* */

import java.util.*;
import java.util.stream.Collectors;

public class ArraySolution {

    public static List<List<Character>> printSubArray(char arr[]){

        List<List<Character>> lists = new ArrayList<>();
        Set<Character> uniqueChar = new LinkedHashSet<>();
        for (int i = 0; i<arr.length; i++){
            uniqueChar.add(arr[i]);
        }
       // System.out.println(uniqueChar);

        int limit = (int) Math.pow(2, arr.length);

        for (int i = 0; i<limit; i++){
            int temp = i;
            LinkedHashSet<Character> characters = new LinkedHashSet<>();

            for (int j = arr.length-1; j>=0;j--){
                int rem = temp%2;
                temp = temp/2;

                if (rem == 0){
                    continue;
                } else {
                    characters.add(arr[j]);
                }
            }
            ArrayList<Character> newCharacters = checkAllChar(characters, uniqueChar);
            Collections.reverse(newCharacters);
            if (!newCharacters.isEmpty()){
                lists.add(newCharacters);
                return lists;
            }

        }
        return null;
    }

    public static ArrayList<Character> checkAllChar(LinkedHashSet<Character> sets, Set uniqueChar){
        if (sets.size() == uniqueChar.size()){
           return (ArrayList<Character>) sets.stream().filter(ch -> uniqueChar.contains(ch)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        char arr[] = {'b','b','c','d','d','a','a','b','b','c','c','d','a'};

        List<List<Character>> result = printSubArray(arr);
        result.stream().forEach(System.out::println);
    }
}
