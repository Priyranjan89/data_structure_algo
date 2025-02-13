package com.my.datastrcture.interview;

import java.util.*;

public class InterestingPairs {
    public static long findIterestingPair(List<Integer> arr, int sumVal) {
        long count = 0;
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (arr.get(i) - arr.get(j)) + (arr.get(i) + arr.get(j)) == sumVal) {
                    count++;
                }
            }
        }

        return count / 2; // Each pair is counted twice, so divide by 2
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 4, -1, 2);
        int sumVal = 4;
        System.out.println(findIterestingPair(arr, sumVal)); // Output: 2
    }
}
