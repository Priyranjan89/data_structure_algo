package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2, 3, 5, 4)) ;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 3, 5, 8, 1, 9)) ;
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(9)) ;
        System.out.println(maximumNonAdjacentSum(nums));
        System.out.println(maximumNonAdjacentSum1(nums));
        System.out.println(maximumNonAdjacentSum1(arr));
        System.out.println(maximumNonAdjacentSum1(arr2));
    }

    private static int dp[];
    //Memoization
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(nums, n-1);
    }

    private static int helper(ArrayList<Integer> nums, int n) {
        if (n < 0){
            return 0;
        }
        if (n == 0){
            return nums.get(n);
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int incl = helper(nums, n-2) + nums.get(n);
        int excl = helper(nums, n-1) + 0;

        return dp[n] = Math.max(incl, excl);
    }

    //Tabulation
    public static int maximumNonAdjacentSum1(ArrayList<Integer> nums) {
        if (nums.size() == 0){
            return 0;
        }
        if (nums.size() == 1){
            return nums.get(0);
        }
        int n = nums.size();
        int dp[] = new int[n];

        dp[0] = nums.get(0);
        dp[1] = nums.get(1);

        for (int i = 2; i < n; i++){
            int incl = dp[i-2] + nums.get(i);
            int excl = dp[i-1] + 0;

            dp[i] = Math.max(incl, excl);
        }
        return dp[n-1];
    }

    //Spece complexcity
    public static int maximumNonAdjSum(ArrayList<Integer> nums){
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
