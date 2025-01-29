package com.my.datastrcture.prectice.leetcode.medium;

public class MinimumNumberOfDaysToMakeMBouquets1482 {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k)); // Output: 3

        bloomDay = new int[]{1, 10, 3, 10, 2};
        m = 3;
        k = 2;
        System.out.println(minDays(bloomDay, m, k)); // Output: -1

        bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        m = 2;
        k = 3;
        System.out.println(minDays(bloomDay, m, k)); // Output: 12
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        long requirement = (long) m * (long) k;
        if (bloomDay.length < requirement)
            return -1;

        int start = getMin(bloomDay); // At least one flower is bloomed
        int end = getMax(bloomDay);   // All flowers are bloomed, definitely can make bouquets
        int ans = 0;

        while (start <= end) {
            int mid = start+(end-start)/2;
            int day = mid;
            if (canWeMakeMBouquetsWithDDays(bloomDay, m, k, day)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canWeMakeMBouquetsWithDDays(int[] bloomDay, int m, int k, int noOfDay) {
        int counter = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            // Check whether the ith flower is bloomed or not
            if (bloomDay[i] <= noOfDay) {
                counter++;
            }
            if (counter == k) {
                m--; // Can make a Bouquet
                counter = 0;
                if (m == 0)
                    break;
            }
            // Not bloomed case
            if (bloomDay[i] > noOfDay) {
                counter = 0;
            }
        }
        return m == 0; // Were you able to make m Bouquets?
    }
    private static int getMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    private static int getMin(int[] piles) {
        int min = 0;
        for (int i = 0; i < piles.length; i++) {
            min = Math.min(min, piles[i]);
        }
        return min;
    }
}
