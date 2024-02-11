package com.my.datastrcture.codingninja.searching;

public class FindClosestIndex {
    public static void main(String[] args) {
        int arr[] = {6, 7, 11, 13, 21, 44, 46};
        int target = 22;
        int left = 0;
        int right = arr.length-1;
        System.out.println(binarySearchClosest(arr, left, right, target));

    }
    public static int binarySearchClosest(int []nums, int left, int right, int target) {
        int ans = -1;
        int mid = left + (right - left)/2;

        while (left <= right){

            if (target == nums[mid]){
                return mid;

            } else if (nums[mid] > target) {
                right = mid - 1;

            } else {
                ans = mid;
                left = mid + 1;

            }
            mid = left + (right - left)/2;
        }

        return ans;
    }
}
