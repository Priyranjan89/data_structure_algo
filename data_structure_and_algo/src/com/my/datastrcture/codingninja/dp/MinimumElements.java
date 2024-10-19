package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumElements {
    public static void main(String[] args) {
        int num[] = {2, 1};
        int x = 11;
        System.out.println(minimumElements(num, x));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int minimumElementsMemo(int num[], int x) {
        int n = num.length;
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>(x+1);
            for (int j = 0; j <= x; j++){
                row.add(-1); //Tab
            }
            dp.add(row);
        }
        //int result = helper(num, x, n-1);
        int result = helperTap(num, x);

        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }
    private static int helper(int arr[], int x, int index){
        //Base
        if (x == 0){
            return 0;
        }
        if (index < 0){
            return Integer.MAX_VALUE-1;
        }
        if (dp.get(index).get(x) != -1){
            return dp.get(index).get(x);
        }
        int take = Integer.MAX_VALUE, noTake;
        noTake = helper(arr, x, index-1);
        if (arr[index] <= x){
            take = 1 + helper(arr, x-arr[index], index);
        }
        int temp = Math.min(take, noTake);
        dp.get(index).set(x, temp);
        return temp;
    }
    private static int helperTap(int[] nums, int x) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0, 0);
        }
        for (int i = 0; i <= x; i++) {
            dp.get(0).set(i, Integer.MAX_VALUE-1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                int take = Integer.MAX_VALUE, noTake;
                noTake = dp.get(i-1).get(j);
                if (j >= nums[i-1]){
                    take = dp.get(i-1).get(j-nums[i-1]);
                }
                dp.get(i).set(x, Math.min(take, noTake));
            }
        }

        return dp.get(n).get(x);
    }

    public static int minimumElements(int[] nums, int x) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int coin : nums) {
            for (int i = coin; i <= x; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[x] == Integer.MAX_VALUE - 1 ? -1 : dp[x];
    }
}
