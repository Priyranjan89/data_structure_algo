package com.my.datastrcture.codingninja.dp;

public class RobCuttingProblem {
    public static void main(String[] args) {
        int price[] = {2,5,7,8,10};
        int price2[] = {3,5,8,9,10,17,17,20};
        int n = 5;
        int n2 = 8;
        System.out.println(cutRod(price, n));
        System.out.println(cutRod(price2, n2));
    }
    public static int cutRod(int price[], int n) {
        int val[] = new int[n+1];
        val[0] = 0;

        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }

    public static int cutRodTap(int price[], int n) {
        // Create a memoization table and initialize it with -1
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return cutRodHelper(price, n, dp);
    }

    private static int cutRodHelper(int[] price, int n, int[] dp) {
        // Base case: If the length of the rod is 0, the cost is 0
        if (n == 0) {
            return 0;
        }

        // If already calculated, return the stored value
        if (dp[n] != -1) {
            return dp[n];
        }

        int maxVal = Integer.MIN_VALUE;

        // Try all possible cuts
        for (int i = 1; i <= n; i++) {
            // Price[i-1] corresponds to the price of length `i`
            maxVal = Math.max(maxVal, price[i - 1] + cutRodHelper(price, n - i, dp));
        }

        // Store the result in the memoization table
        dp[n] = maxVal;

        return maxVal;
    }
}
