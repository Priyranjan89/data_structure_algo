package com.my.datastrcture.prectice.leetcode.hard;

public class SplitArrayLargestSum410 {
    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        if (n < k){
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        int end = sum;
        int mid = start+(end-start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(nums, n, k, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
            mid = start+(end-start)/2;
        }
        return ans;
    }
    private static boolean isPossible(int[] nums, int n, int k, long mid) {
        int numberOfK = 1;
        int sumOfSubArray = 0;

        for (int i = 0; i < n; i++){
            if (sumOfSubArray + nums[i] <= mid){
                sumOfSubArray += nums[i];
            } else {
                numberOfK++;
                if (numberOfK > k || nums[i] > mid){
                    return false;
                }
                sumOfSubArray = nums[i];
            }
        }
        return true;
    }
}
