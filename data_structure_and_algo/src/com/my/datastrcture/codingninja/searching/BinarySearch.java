package com.my.datastrcture.codingninja.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 9, 11, 12, 45};
        int key = 11;
        System.out.println(search(arr, key));

    }

    public static int search(int []nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right - left)/2;

        while (left <= right){

            if (nums[mid] == target){
                return mid;

            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
            mid = left + (right - left)/2;
        }
        return -1;
    }
}
