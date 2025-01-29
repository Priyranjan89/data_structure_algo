package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class LongestSubArrayZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // HashMap to store the first occurrence of each cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int cumulativeSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update cumulative sum
            cumulativeSum += arr[i];

            // Case 1: If cumulative sum is zero, then the subarray from 0 to i has zero sum
            if (cumulativeSum == 0) {
                maxLength = i + 1;
            }

            // Case 2: If cumulative sum is seen before, there exists a zero-sum subarray
            if (map.containsKey(cumulativeSum)) {
                // Calculate the length of this subarray
                int previousIndex = map.get(cumulativeSum);
                int subarrayLength = i - previousIndex;
                maxLength = Math.max(maxLength, subarrayLength);
            } else {
                // Store the first occurrence of this cumulative sum
                map.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }
}
