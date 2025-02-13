package com.my.datastrcture.prectice.hashMap;

import java.util.*;

public class PairSumUsingHashMap {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 5, 4, 6, 2};
        int target = 6;

        System.out.println("Using Map");
        findPairs(arr, target);
        System.out.println("Using Set");
        findPairsSet(arr,target);
    }

    public static void findPairs(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int tI = 0;


        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Instead of containsKey(), use get() to check for complement existence
            if (map.get(complement) != null) {
                System.out.println("(" + complement + ", " + arr[i] + ")");
            }

            // Store the current number in the map with its index
            map.put(arr[i], i);
        }
    }

    public static void findPairsSet(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }
            seen.add(num);

        }
    }
    public static void findPairs2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }

            // Store the number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
}
