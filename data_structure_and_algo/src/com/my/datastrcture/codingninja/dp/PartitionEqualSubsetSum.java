package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr1[] = {3, 1, 1, 2, 2, 1};
        int n1 = 6;
        int arr2[] = {5, 6, 5, 11, 6};
        int n2 = 5;
        System.out.println(canPartition(arr1, n1));
        System.out.println(canPartition(arr2, n2));
    }

    private static ArrayList<ArrayList<Boolean>> dp;
    public static boolean canPartition(int[] arr, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += arr[i];
        }
        dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            ArrayList<Boolean> row = new ArrayList<>(k + 1);
            for (int j = 0; j <= k; j++) {
                //row.add(null); Memo
                row.add(false); //Tab
            }
            dp.add(row);
        }

        if (k % 2 == 1) {
            return false;
        } else {
            k = k / 2;
            return helperTap(arr, n, k);
        }
    }

    private static boolean helperTap(int arr[], int n, int k){
        for (int i = 0; i <= n; i++){
            dp.get(i).set(0, true);
        }
        for (int i = 1; i <= k; i++){
            dp.get(0).set(i, false);
        }

        for (int i = 1; i <= n; i++){
            for( int j = 1; j <= k; j++){
                boolean take = false, noTake;
                noTake = dp.get(i-1).get(j);
                if (j >= arr[i-1]){
                    take = dp.get(i-1).get(j-arr[i-1]);
                }
                dp.get(i).set(j, take || noTake);
            }
        }
        return dp.get(n).get(k);
    }

    private static boolean helper(int arr[], int n, int k, int index) {
        //base
        if (k == 0)
            return true;
        if (index < 0)
            return false;
        if (dp.get(index).get(k) != null) {
            return dp.get(index).get(k);
        }
        boolean take = false, noTake;
        noTake = helper(arr, n, k, index - 1);
        if (arr[index] <= k)
            take = helper(arr, n, k - arr[index], index - 1);

        boolean temp = noTake || take;
        dp.get(index).set(k, temp);
        return temp;
    }
}
