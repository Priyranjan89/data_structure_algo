package com.my.datastrcture.prectice.hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int arr[] = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};

        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr);
        for (int num : ans){
            System.out.print(num+" ");
        }
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        int startOfLongest = arr[0];

        // Populate map with each element's index in the array
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int num : arr) {
            if (!map.containsKey(num - 1)) { // Check if it's the start of a sequence
                int currentLength = 1;
                int currentNum = num;

                // Find the length of the sequence
                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update result if a longer sequence is found
                if (currentLength > maxLength ||
                        (currentLength == maxLength && map.get(num) < map.get(startOfLongest))) {
                    maxLength = currentLength;
                    startOfLongest = num;
                }
            }
        }

        // Prepare the result based on the longest sequence found
        result.add(startOfLongest);
        if (maxLength > 1) {
            result.add(startOfLongest + maxLength - 1);
        }

        return result;
    }
}
