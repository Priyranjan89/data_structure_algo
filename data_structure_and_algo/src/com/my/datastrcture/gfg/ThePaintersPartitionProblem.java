package com.my.datastrcture.gfg;

public class ThePaintersPartitionProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int arr[] = {5,10,30,20,15};
        System.out.println(minTime(arr, n, k));
    }

    static long minTime(int[] arr,int n,int k){
        long start = 0;
        long sum = 0;

        if (n < k){
            return -1;
        }

        for (int i = 0; i < n; i++){
            sum += arr[i];
        }

        long end  = sum;
        long mid = start + (end - start)/2;
        long ans = -1;

        while (start <= end){
            if (isPossible(arr, n, k, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int n, int k, long mid) {
        int studentCount = 1;
        long pageSum = 0;

        for (int i = 0; i < n; i++){
            if (pageSum + arr[i] <= mid){
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > k || arr[i] > mid){
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
}
