package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class PairsWithDifferenceK {

    public static void main(String[] args) {
        int arr[] = {5,1,2,4};
        int  k = 3;
        System.out.println(getPairsWithDifferenceK(arr,k));
    }

    public static int getPairsWithDifferenceK(int arr[], int k) {
        // HashMap to store frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill the hashmap with elements and their counts
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        // Traverse each unique element in the hashmap
        for (int num : map.keySet()) {
            int freq = map.get(num);

            // Case 1: When k = 0, count pairs within the same element
            if (k == 0) {
                count += (freq * (freq - 1)) / 2;
            } else {
                // Case 2: When k > 0, check for num + k and num - k in the hashmap
                if (map.containsKey(num + k)) {
                    count += freq * map.get(num + k);
                }
                if (map.containsKey(num - k)) {
                    count += freq * map.get(num - k);
                }
            }

            // Avoid double-counting for k != 0 by only counting in one direction
            map.put(num, 0);
        }

        return count;
    }
}
