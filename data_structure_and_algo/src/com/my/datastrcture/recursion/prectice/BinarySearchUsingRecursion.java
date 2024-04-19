package com.my.datastrcture.recursion.prectice;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 9, 11, 12, 45};
        int k = 7;

        System.out.println(search(arr, k));
    }

    public static int search(int []nums, int target) {
        int start = 0;
        int end = nums.length-1;
        return binarySearch(nums, start, end, target);
    }

    private static int binarySearch(int[] a, int start, int end, int k){
        if (start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if (a[mid] == k){
            return mid;

        } else if (a[mid] < k){
            start = mid+1;
        } else {
            end = mid - 1;
        }
        return binarySearch(a, start, end, k);
    }
}
