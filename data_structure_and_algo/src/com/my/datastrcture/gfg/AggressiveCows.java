package com.my.datastrcture.gfg;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int n=5;
        int k=3;
        int []stalls = {1,2,4,8,9};
        System.out.println(solve(n, k, stalls));
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start = 0;
        int end = stalls[n-1];
        int mid = start +(end-start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(stalls, n, k, mid)){
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
            mid = start +(end-start)/2;
        }
        return ans;
    }
    public static boolean isPossible(int stalls[], int n, int k, int mid){
        int cowCount = 1;
        int lastPosition = stalls[0];

        for (int i = 0; i < n; i++){
            if (stalls[i] - lastPosition >= mid){
                cowCount++;
                if (cowCount == k){
                    return true;
                }
                lastPosition = stalls[i];
            }
        }
        return false;
    }
}
