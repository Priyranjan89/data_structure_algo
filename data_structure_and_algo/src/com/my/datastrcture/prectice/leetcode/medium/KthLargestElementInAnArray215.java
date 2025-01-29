package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Random;

public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        int input[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(input, k));

    }

    /*public static int findKthLargest(int[] nums, int k) {
        int pivot = partition(nums, 0, nums.length - 1);
        k = nums.length - k;
        while (pivot != k) {
            if (pivot > k) {
                pivot = partition(nums, 0, pivot - 1);
            } else {
                pivot = partition(nums, pivot + 1, nums.length - 1);
            }
        }
        return nums[pivot];
    }*/

    public int findKthLargestBest(int[] nums, int k) {
        int arr[]=new int[20001];
        for(int n:nums){
            arr[n+10000]++;
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>0){
                k-=arr[i];
                if(k<=0){
                    return i-10000;
                }
            }
        }
        return -1;
    }

    public static int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (true) {
            int pivot_index = left + rand.nextInt(right - left + 1);
            int new_pivot_index = partition(nums, left, right, pivot_index);
            if (new_pivot_index == nums.length - k) {
                return nums[new_pivot_index];
            } else if (new_pivot_index > nums.length - k) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }



    /*private static int partition(int input[], int start, int end) {
        if (start == end) {
            return start;
        }
        int pivot = input[start];
        int count = 0;

        for (int i = start + 1; i <= end; i++) {
            if (input[i] <= pivot) {
                count++;
            }
        }

        int pivotIndex = start + count;
        swap(input, start, pivotIndex);

        int i = start, j = end;
        while (i < j) {
            if (pivot >= input[i]) {
                i++;
            } else if (pivot < input[j]) {
                j--;
            } else {
                swap(input, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }*/

    private static void swap(int input[], int start, int end) {
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}
