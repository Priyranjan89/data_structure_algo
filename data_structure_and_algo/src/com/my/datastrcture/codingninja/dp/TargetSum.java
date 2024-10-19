package com.my.datastrcture.codingninja.dp;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1};
        int n = 5;
        int target = 3;
        System.out.println(targetSum(n, target, arr));
    }

    public static int targetSum(int n, int target, int[] arr) {
        if (arr == null || n == 0) return 0;

        int sum = 0;
        for (int num : arr) sum += num;
        if (sum < Math.abs(target)) return 0;

        // create dp, and init
        int m = (sum << 1) + 1;
        int[][] dp = new int[n][m];
        dp[0][sum - arr[0]] += 1;
        dp[0][sum + arr[0]] += 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
                if (j + arr[i] < m) {
                    dp[i][j] += dp[i - 1][j + arr[i]];
                }
            }
        }

        return dp[n - 1][target + sum];
    }

}
