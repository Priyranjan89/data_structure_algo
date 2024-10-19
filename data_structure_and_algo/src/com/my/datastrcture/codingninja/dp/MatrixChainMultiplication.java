package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[]= {10,15,20,25};
        int N = 4;
        System.out.println(matrixMultiplication(arr, N));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int matrixMultiplication(int[] arr , int N) {
        dp = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++){
            ArrayList<Integer> row = new ArrayList<>(N+1);
            for (int j = 0; j <= N; j++){
                row.add(-1); //Tab
            }
            dp.add(row);
        }
        //return helperMemo(arr, 1, N-1);
        return helperTap(arr, N);
    }
    private static int helperMemo(int arr[], int i, int j) {
        if (i == j)
            return 0;
        if (dp.get(i).get(j) != -1)
            return dp.get(i).get(j);

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = helperMemo(arr, i, k) + helperMemo(arr, k + 1, j) + arr[i-1] * arr[k] * arr[j];
            mini = Math.min(mini, temp);
        }
        dp.get(i).set(j, mini);
        return mini;
    }
    private static int helperTap(int arr[], int n){
        for (int i = 0; i < n; i++)
            dp.get(i).set(i, 0);

        for (int i = n-1; i >=1; i--){
            for (int j = i+1; j < n; j++){
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    int temp = dp.get(i).get(k) + dp.get(k+1).get(j) + arr[i-1]*arr[k]*arr[j];
                    mini = Math.min(mini, temp);
                }
                dp.get(i).set(j, mini);
            }
        }
        return dp.get(1).get(n-1);
    }
}
