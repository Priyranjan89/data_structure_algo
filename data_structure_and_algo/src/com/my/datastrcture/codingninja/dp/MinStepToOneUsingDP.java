package com.my.datastrcture.codingninja.dp;

import java.util.Arrays;

public class MinStepToOneUsingDP {
    public static void main(String[] args) {
       // System.out.println(countMinStepsToOne(4));
        System.out.println(minStepsToOne(7));
    }

    public static int countMinStepsToOne(int n) {
        int dp[]=new int[n+1];
        dp[1]=0;

        for(int i=2;i<dp.length;i++)
        {
            int op1=Integer.MAX_VALUE;
            int op2=Integer.MAX_VALUE;
            int op3=Integer.MAX_VALUE;
            op1=dp[i-1];
            if(i%2==0)
                op2=dp[i/2];
            if(i%3==0)
                op3=dp[i/3];
            dp[i]=1+Math.min(Math.min(op1,op2),op3);
        }
        return dp[n];
    }

    public static int minSteps(int n, int[] memo) {
        if (n == 1) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int steps = Integer.MAX_VALUE;

        // Step 1: Subtract 1
        steps = Math.min(steps, 1 + minSteps(n - 1, memo));

        // Step 2: Divide by 2 if possible
        if (n % 2 == 0) {
            steps = Math.min(steps, 1 + minSteps(n / 2, memo));
        }

        // Step 3: Divide by 3 if possible
        if (n % 3 == 0) {
            steps = Math.min(steps, 1 + minSteps(n / 3, memo));
        }

        memo[n] = steps;

        return steps;
    }

    public static int minStepsToOne(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return minSteps(n, memo);
    }
   /* public static int minSteps(int n, int[] dp) {
        if (n == 1){
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
         int steps = Integer.MAX_VALUE;

        steps = Math.min(steps, 1 + minSteps(n-1, dp));

        if (n%2 == 0){
            steps = Math.min(steps, 1 + minSteps(n/2, dp));
        }

        if (n%3 == 0){
            steps = Math.min(steps, 1 + minSteps(n/3, dp));
        }

        dp[n] = steps;

        return steps;
    }*/
}
