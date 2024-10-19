package com.my.datastrcture.binary.search;

public class ExponentialSearch {
    public static void main(String[] args) {
        int arr[] = {3,4,5,6,11,13,14,15,56,70};
        int x = 13;
        System.out.println(expSearch(arr, x));
    }

    public static int expSearch(int arr[], int x){
        if (arr[0] == x){
            return 0;
        }
        int n = arr.length;
        int i = 1;

        while (i < n && arr[i] <= x){
            i = i*2;
        }
        return binarySearch(arr, i/2, Math.min(i, n-1), x);
    }

    private static int binarySearch(int nums[], int start, int end, int target){
        int mid = start + (end - start) / 2;

        while (start <= end){
            if (nums[mid] == target){
                return mid;
            } else if (target > nums[mid] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }
}
