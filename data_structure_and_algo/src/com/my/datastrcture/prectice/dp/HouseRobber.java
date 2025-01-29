package com.my.datastrcture.prectice.dp;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = {1, 5, 1, 2, 6};
        //System.out.println(houseRobber(arr));
        System.out.println(houseRobber2(arr));
    }

    //Memoization
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;

        if (n == 0)
            return 0;
        if (n == 1){
            return valueInHouse[0];
        }

        // Memoization arrays for the two cases
        long dp1[] = new long[n]; // For robbing from house 0 to n-2
        long dp2[] = new long[n]; // For robbing from house 1 to n-1
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Return the maximum of the two cases
        return Math.max(
                helper(valueInHouse, 0, n-2, dp1), // Exclude last house
                helper(valueInHouse, 1, n-1, dp2)); // Exclude First house
    }

    private static long helper(int[] valueInHouse, int start, int end, long dp[]) {
        //Base case
        if (end < start){
            return 0;
        }

        // If already computed, return the cached result
        if (dp[end] != -1){
            return dp[end];
        }

        // Compute the maximum money
        //Robber this house
        long rob = helper(valueInHouse, start, end-2, dp) + valueInHouse[end];
        //Skip thi house
        long skip = helper(valueInHouse, start, end-1, dp) + 0;

        // Store and return the result
        return dp[end] = Math.max(rob, skip);
    }

    //Tabulation
    public static long houseRobber2(int[] valueInHouse) {
        int n = valueInHouse.length;

        if (n == 0)
            return 0;
        if (n == 1){
            return valueInHouse[0];
        }

        return Math.max(
                helper2(valueInHouse, 0, n-2), // Exclude last house
                helper2(valueInHouse, 1, n-1)); // Exclude First house
    }

    private static long helper2(int[] valueInHouse, int start, int end) {
        if (start > end){
            return 0;
        }

        long prev2 = 0; //dp[i-2]
        long prev1 = 0; //dp[i-1]
        for (int i = start; i <= end; i++){
            long current = Math.max(prev1, prev2+valueInHouse[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
