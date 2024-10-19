package com.my.datastrcture.gfg;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int n = 4;
        int arr[] = {12,34,67,90};
        int m = 5;
        System.out.println(findPages(n, arr, m));
    }

    public static long findPages(int n, int[] arr, int m) {
        long start = 0;
        long sum = 0;

        if (n < m){
            return -1;
        }

        for (int i = 0; i < n; i++){
            sum += arr[i];
        }

        long end  = sum;
        long mid = start + (end - start)/2;
        long ans = -1;

        while (start <= end){
            if (isPossible(arr, n, m, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int n, int m, long mid) {
        int studentCount = 1;
        long pageSum = 0;

        for (int i = 0; i < n; i++){
            if (pageSum + arr[i] <= mid){
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > m || arr[i] > mid){
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
}
