package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {5,4,11,1,16,8};
        int arr1[] = {5,5,5,5,5,5,5,5,5,5};
        System.out.println(longestIncreasingSubsequence(arr));
        System.out.println(longestIncreasingSubsequence(arr1));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int longestIncreasingSubsequence1(int arr[]) {
        int n = arr.length;
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>(n+1);
            for (int j = 0; j <= n; j++){
                row.add(-1); //Tab
            }
            dp.add(row);
        }
        return helperTap(arr);
    }

    private static int helperTap(int arr[]){
        if(arr.length==0)
            return 1;
        int storage[]=new int[arr.length];
        storage[0]=1;

        for(int i=1;i<storage.length;i++){

            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i] && storage[i]<storage[j]+1)
                    storage[i]=storage[j]+1;
                else
                    storage[i]=Math.max(1,storage[i]);
            }}
        int max=storage[0];
        for(int i=1;i<storage.length;i++){
            if(storage[i]>max)
                max=storage[i];
        }
        return max;
    }

    private static int helperTap1(int arr[], int n){
        for (int i = 0;  i <= n; i++){
            for (int j = 0; j <= n; j++){
                dp.get(i).set(j, 0);
            }
        }
        for (int idx = n-1; idx >= 0; idx--){
            for (int preIdx = idx-1; preIdx>= -1; preIdx--){
                int take = Integer.MIN_VALUE, noTake;
                noTake = dp.get(idx+1).get(preIdx+1);
                if (preIdx == -1 || arr[idx] > arr[preIdx])
                    take = dp.get(idx+1).get(idx+1) + 1;
                int temp = Math.max(take, noTake);
                dp.get(idx).set(preIdx+1, temp);
            }
        }
        return dp.get(0).get(0);
    }

    private static int helperMemo(int arr[], int n, int idx, int preIdx){
        if (idx == n)
            return 0;
        if (dp.get(idx).get(preIdx+1) != -1)
            return dp.get(idx).get(preIdx+1);

        int take = Integer.MIN_VALUE, noTake;
        noTake = helperMemo(arr, n, idx+1, preIdx);
        if (preIdx == -1 || arr[idx] > arr[preIdx])
            take = helperMemo(arr, n, idx+1, idx) + 1;

        int temp = Math.max(take, noTake);
        dp.get(idx).set(preIdx+1, temp);
        return temp;
    }

    public static int longestPalindromeSubsequence(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        Integer[] tail = new Integer[n];
        int len = 1;
        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] > tail[len - 1]) {
                tail[len++] = arr[i];
            } else {

                int index = Arrays.binarySearch(tail, 0, len, arr[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                tail[index] = arr[i];
            }
        }

        return len;
    }
    public static int longestIncreasingSubsequenceChat(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // dp array to store the smallest ending element of all increasing subsequences of different lengths
        int[] dp = new int[n];
        // Length of the longest increasing subsequence found so far
        int len = 0;

        for (int num : arr) {
            // Use binary search to find the position where 'num' can replace in dp array
            int idx = Arrays.binarySearch(dp, 0, len, num);

            if (idx < 0) {
                idx = -(idx + 1); // Get the insertion point
            }

            // Replace the element at idx with 'num'
            dp[idx] = num;

            // If 'num' extends the current longest subsequence, update the length
            if (idx == len) {
                len++;
            }
        }

        return len;
    }

}
