package com.my.datastrcture.prectice.leetcode.medium;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h)); // Output: 4

        piles = new int[]{30, 11, 23, 4, 20};
        h = 5;
        System.out.println(minEatingSpeed(piles, h)); // Output: 30

        piles = new int[]{30, 11, 23, 4, 20};
        h = 6;
        System.out.println(minEatingSpeed(piles, h)); // Output: 23
    }

    public static int minEatingSpeed1(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int k = mid;
            if (canKokoFinishBananasWithKSpeed(piles, h, k)) {
                ans = k;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canKokoFinishBananasWithKSpeed(int[] piles, int h, int k) {
        long totalHoursTakenByKokoToFinishAllBananas = 0;
        for (int pile : piles) {
            totalHoursTakenByKokoToFinishAllBananas += Math.ceil(pile / (double) k);
        }
        return totalHoursTakenByKokoToFinishAllBananas <= h;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1; // Minimum possible eating speed is 1
        int high = maxpiles(piles);

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canfinish(piles, mid, h)) {
                high = mid; // Try to find a smaller speed
            } else {
                low = mid + 1; // Increase the speed
            }
        }
        return low;
    }

    public static int maxpiles(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static boolean canfinish(int[] piles, int mid, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + mid - 1) / mid; // Ceiling division
        }
        return hours <= h;
    }

}
