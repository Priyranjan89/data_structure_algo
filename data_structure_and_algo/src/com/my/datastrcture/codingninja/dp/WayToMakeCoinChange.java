package com.my.datastrcture.codingninja.dp;

public class WayToMakeCoinChange {
    public static void main(String[] args) {
        int[] denominations1 = {1, 2, 3};
        int value1 = 4;
        System.out.println(countWaysToMakeChange(denominations1, value1)); // Output: 4

        int[] denominations2 = {5, 3, 2};
        int value2 = 1;
        System.out.println(countWaysToMakeChange(denominations2, value2)); // Output: 0
    }
    public static long countWaysToMakeChange(int[] denominations, int value) {
        // Initialize DP array
        long[] dp = new long[value + 1];
        dp[0] = 1; // Base case: 1 way to make change for amount 0 (by choosing no coins)

        // Process each coin denomination
        for (int denom : denominations) {
            for (int i = denom; i <= value; i++) {
                dp[i] += dp[i - denom];
            }
        }

        // Return the number of ways to make change for the given value
        return dp[value];
    }
}
