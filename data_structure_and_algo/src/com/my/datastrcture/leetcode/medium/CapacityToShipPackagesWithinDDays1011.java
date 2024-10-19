package com.my.datastrcture.leetcode.medium;

public class CapacityToShipPackagesWithinDDays1011 {
    public static void main(String[] args) {
        int n = 10;
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println( shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int sum = 0;
        int n = weights.length;

        if (n < days){
            return -1;
        }

        for (int i = 0; i < n; i++){
            sum += weights[i];
        }

        int end  = sum;
        int mid = start + (end - start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(weights, n, days, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    private static boolean isPossible(int[] weights, int n, int days, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++){
            if (pageSum + weights[i] <= mid){
                pageSum += weights[i];
            } else {
                studentCount++;
                if (studentCount > days || weights[i] > mid){
                    return false;
                }
                pageSum = weights[i];
            }
        }
        return true;
    }
}
