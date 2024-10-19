package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        int num[] = {1, 1, 4, 5};
        int tar = 5;
        int num2[] = {0,1,3};
        int tar2 = 4;
        System.out.println(findWays(num, tar));
        System.out.println(findWays(num2, tar2));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int findWays(int num[], int tar) {
        int n = num.length;
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>(tar+1);
            for (int j = 0; j <= tar; j++){
                //row.add(null); Memo
                row.add(-1); //Tab
            }
            dp.add(row);
        }
        return helperTap(num, n, tar);
    }

    private static int helperTap(int arr[], int n, int k){
        int[] dp = new int[k + 1];

        // Initialize dp[0] as 1 because there is one way to achieve sum 0, i.e., by not choosing any element
        dp[0] = 1;

        // Iterate over each element in the array
        for (int i = 0; i < n; i++) {
            // Update dp array from right to left to prevent double counting
            for (int j = k; j >= arr[i]; j--) {
                // Update dp[j] by adding the number of ways to achieve sum 'j - arr[i]'
                dp[j] = (dp[j] + dp[j - arr[i]]) % 1000000007; // Take modulo to prevent overflow
            }
        }

        // Return the number of ways to achieve the target sum 'k'
        return dp[k];
    }

    private static int helper(int arr[], int n, int k, int index){
        //base
        if (k == 0)
            return 1;
        if (index < 0)
            return 0;
        if (dp.get(index).get(k) != -1){
            return dp.get(index).get(k);
        }
        int take = 0, noTake;
        noTake = helper(arr, n, k, index-1);
        if (arr[index] <= k)
            take = helper(arr, n, k-arr[index], index-1);

        int temp = (noTake + take) % 1000000007;
        dp.get(index).set(k, temp);
        return temp;
    }
}
