package com.my.datastrcture.prectice.leetcode.medium;

public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums)); // Output: 2

        int[]nums1 = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums1)); // Output: 1 or 5

        int[]nums2 = new int[]{ 5, 6, 1, 2, 3, 4};
        System.out.println(findPeakElement(nums2)); // Output: 1 or 5
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int start = 1, end = n - 2;
        int mid = start+(end-start)/2;

        while (start <= end) {
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start+(end-start)/2;
        }
        return -1;
    }
}
