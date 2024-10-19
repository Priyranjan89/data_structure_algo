package com.my.datastrcture.leetcode.medium;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int []position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 0;
        int end = position[n-1];
        int mid = start +(end-start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(position, n, m, mid)){
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
            mid = start +(end-start)/2;
        }
        return ans;
    }
    public static boolean isPossible(int position[], int n, int m, int mid){
        int ballCount = 1;
        int lastPos = position[0];

        for (int i = 0; i < n; i++){
            if (position[i] - lastPos >= mid){
                ballCount++;
                if (ballCount == m){
                    return true;
                }
                lastPos = position[i];
            }
        }
        return false;
    }

}
