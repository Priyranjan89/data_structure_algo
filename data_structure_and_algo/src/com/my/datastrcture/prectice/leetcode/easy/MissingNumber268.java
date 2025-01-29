package com.my.datastrcture.prectice.leetcode.easy;

import java.util.Arrays;

public class MissingNumber268 {
    public static void main(String[] args) {
        int nums[] = {3, 0, 1};
        int nums1[] = {0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums1));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ansIndex = -1;
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            int diff = nums[mid] - mid;
            if (diff == 0) {
                //right me ans milega
                s = mid + 1;
            } else if (diff == 1) {
                //store and compute
                ansIndex = mid;
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        //ye mujhse galat hogya tha
        //for extreme right element missing case, we
        //are hardcoding the logic below
        if (ansIndex == -1) {
            return n;
        }
        return ansIndex;
    }

    public int missingNumber1(int[] nums) {
        //int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int n=nums.length;
        int ans=0;
        for(int i=0;i<=n;i++){
            ans=ans^i;
        }
        for(int i=0;i<n;i++){
            ans=ans^nums[i];
        }
        return ans;

    }
}
