package com.my.datastrcture.leetcode.easy;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0}, m = 3, nums2[] = {2,5,6}, n = 3;
        merge(nums1, m, nums2, n);
        for (int num : nums1){
            System.out.print(num+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;

        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
               nums1[k] = nums2[j];
               j--;
            }
            k--;
        }
        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

   /* public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1 (actual elements)
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the end of nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If elements remain in nums2, copy them over
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    */
}
