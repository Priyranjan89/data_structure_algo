package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);
        nums.add(9);

        int ans = maximumNonAdjacentSum(nums);
        System.out.println(ans);
    }

    private static int dp[];
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
       int n = nums.size();
        dp = new int[n];
        Arrays.fill(dp, -1);
       //return helper(nums, n-1);
       return helper3(nums);
    }

    //Memoization
    private static int helper(ArrayList<Integer> nums, int n){
        if (n < 0){
            return 0;
        }
        if (n == 0){
            return nums.get(0);
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int inc = helper(nums, n-2) + nums.get(n);
        int excl = helper(nums, n-1) + 0;
        return dp[n] = Math.max(inc, excl);
    }

    //Tabulation
    private static int helper2(ArrayList<Integer> nums){
        int n = nums.size();
        int dp[] = new int[n];
        dp[0] = nums.get(0);
        for (int i = 1; i < n; i++){
            int inc = 0;
            if (i-2 > 0){
                inc = dp[i-2] + nums.get(i);
            }
            int excl = dp[i-1] +0;;
            dp[i] = Math.max(inc, excl);
        }
        return dp[n-1];
    }

    //space complexcity
    private static int helper3(ArrayList<Integer> nums){
        int n = nums.size();

        int prev2 = 0;
        int prev1 = nums.get(0);
        for (int i = 1; i < n; i++){
            int inc = prev2 + nums.get(i);
            int excl = prev1 +0;;
            int ans = Math.max(inc, excl);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}
