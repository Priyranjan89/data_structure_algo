package com.my.datastrcture.binary.search;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int stalls[] ={4, 2, 1, 3, 6};
        int k = 2;

        System.out.println("Maximum distance between Aggressive cows: "+aggressiveCows(stalls, k));
    }

    public static int aggressiveCows(int []stalls, int k) {
        int start = 0;
       // int maxi = -1;
        Arrays.sort(stalls);
        int n = stalls.length;
       /* for (int i = 0; i < stalls.length; i++){
            maxi = max(maxi, stalls[i]);
        }*/

        int end = stalls[n-1];
        int mid = start +(end-start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(stalls, stalls.length, k, mid)){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start +(end-start)/2;
        }

        return ans;
    }

    public static boolean isPossible(int stalls[], int n, int k, int mid){
        int cowCount = 1;
        int lastPos = stalls[0];

        for (int i = 0; i < n; i++){
            if (stalls[i] - lastPos >= mid){
                cowCount++;
                if (cowCount == k){
                    return true;
                }
                lastPos = stalls[i];
            }
        }

        return false;
    }
}
