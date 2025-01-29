package com.my.datastrcture.prectice.dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 10};
        int arr1[] = {7, 4, 4, 2, 6, 6, 3, 4};
        int arr2[] = {4, 8, 3, 10, 4, 4};
        /*System.out.println(frogJump(arr.length, arr));
        System.out.println(frogJump2(arr.length, arr));*/
        System.out.println(frogJump2(arr1.length, arr1));
        System.out.println(frogJump2(arr2.length, arr2));
    }

    private static int dp[];
    //Memoization
    public static int frogJump(int n, int heights[]) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, heights);
    }

    private static int helper(int n, int[] heights) {
        //Base case
        if (n == 1){
            return 0;
        }

        if (dp[n] != -1){
            return dp[n];
        }
        //Choice
        int opt1 = 0, opt2 = Integer.MAX_VALUE;
        opt1 = Math.abs(heights[n -1] - heights[n -2]) + helper(n -1, heights);
        if (n -2 > 0){
            opt2 = Math.abs(heights[n -1] - heights[n -3]) + helper(n -2, heights);
        }

        //Optimal
        return dp[n] = Math.min(opt1, opt2);
    }

    //Tabulation
    public static int frogJump2(int n, int heights[]) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        int opt1 = 0, opt2 = Integer.MAX_VALUE;

        for (int i = 2; i <= n; i++){
            opt1 = Math.abs(heights[i-1] - heights[i-2]) + dp[i-1];
            if (i-2 > 0){
                opt2 = Math.abs(heights[i-1] - heights[i-3]) + dp[i-2];
            }

            dp[i] = Math.min(opt1, opt2);
        }
        return dp[n];
    }

}
