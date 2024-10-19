package com.my.datastrcture.codingninja.dp;

import java.util.Arrays;

public class PartitionsWithGivenDifference {
    public static void main(String[] args) {

        int n1= 4, d1 = 3;
        int arr1[] = {5, 2, 4, 6};
        int n2= 4, d2 = 0;
        int arr2[] = {1, 1, 1, 1};
        System.out.println(countPartitions(n1, d1, arr1));
        System.out.println(countPartitions(n2, d2, arr2));
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int MOD = 1000000007;
        int totalSum = Arrays.stream(arr).sum();

        // Initialize a 2D DP array
        int[][] dp = new int[n + 1][totalSum + 1];

        // Base case: There is 1 way to achieve sum 0 with an empty subset
        dp[0][0] = 1;

        // Fill the DP array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];

                // Include the current element if it doesn't exceed the total sum
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }

        // Count the number of partitions that satisfy the given conditions
        int count = 0;
        for (int i = (totalSum + 1) / 2; i <= totalSum; i++) {
            if (Math.abs(i - (totalSum - i)) == d) {
                count = (count + dp[n][i]) % MOD;
            }
        }

        return count;
    }

    public static int countPartitionsMemo(int n, int d, int[] arr) {
        // Initialize DP table
        int[][][] dp = new int[n][2501][2]; // Index, Sum difference, Subset

        // Call recursive function with initial parameters
        return countPartitionsHelper(arr, 0, 0, 0, d, dp);
    }

    // Recursive helper function with dynamic programming
    public static int countPartitionsHelper(int[] arr, int index, int sum1, int sum2, int d, int[][][] dp) {
        // Base cases
        if (index == arr.length) {
            return Math.abs(sum1 - sum2) == d ? 1 : 0;
        }
        if (dp[index][Math.abs(sum1 - sum2)][0] != 0) {
            return dp[index][Math.abs(sum1 - sum2)][0];
        }

        // Recursive cases
        int count = 0;
        count += countPartitionsHelper(arr, index + 1, sum1 + arr[index], sum2, d, dp);
        count %= 1000000007; // Take modulo to prevent overflow
        count += countPartitionsHelper(arr, index + 1, sum1, sum2 + arr[index], d, dp);
        count %= 1000000007; // Take modulo to prevent overflow

        dp[index][Math.abs(sum1 - sum2)][0] = count;

        return count;
    }
}
