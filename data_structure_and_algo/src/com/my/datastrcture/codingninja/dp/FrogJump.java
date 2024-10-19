package com.my.datastrcture.codingninja.dp;

import java.util.Arrays;

public class FrogJump {
    private static int dp[];
    public static void main(String[] args) {
        int heights[] = {10, 20, 30, 10};
        int n = 4;

        System.out.println(frogJump(n, heights));
    }

    public static int frogJump(int n, int heights[]) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
       return helper2(n, heights);
    }

    //Memoization
    private static int helper(int n, int heights[]){
        if (n == 1){
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        //choices
        int op1, op2 = Integer.MAX_VALUE;
        op1 = Math.abs(heights[n-1] - heights[n-2]) + helper(n-1, heights);
        if (n-2 > 0){
            op2 = Math.abs(heights[n-1] - heights[n-3]) + helper(n-2, heights);
        }
        //Optimal
        return dp[n] = Math.min(op1, op2);
    }

    //Tabulation
    private static int helper2(int n, int heights[]){
       dp[0] = 0;
       dp[1] = 0;

       for (int i = 2; i <= n; i++){
           int op1, op2 = Integer.MAX_VALUE;
           op1 = Math.abs(heights[i-1] - heights[i-2]) + dp[i-1];
           if (i-2 > 0){
               op2 = Math.abs(heights[i-1] - heights[i-3]) + dp[i-2];
           }
           dp[i] = Math.min(op1, op2);
       }
       return dp[n];
    }
}
