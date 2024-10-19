package com.my.datastrcture.leetcode.medium;

import java.util.Arrays;

public class KDiffPairsInAnArray532 {
    public static void main(String[] args) {
       /* int nums[] = {3,1,4,1,5};
        int k = 2;
        System.out.println(findPairs(nums, k));
        int nums2[] = {1,2,3,4,5};
        int k2 = 1;
        System.out.println(findPairs(nums2, k2));*/

        int nums3[] = {1,3,1,5,4};
        int k3 = 0;
        System.out.println(findPairs(nums3, k3));
    }
    public static int findPairs(int[] nums, int k) {
        int count  = 0;
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0 || n == 1){
            return 0;
        }

        int i = 0;
        int j = 1;
        while (j < n ){
            int diff = nums[j] - nums[i];

            if(diff==k){
                count++;
                i++;
                j++;
            }else if(diff < k){
                j++;
            }else{
                i++;
            }
            while(j < nums.length && nums[j] == nums[j-1]){
                j++;
            }
            if(i == j){
                j++;
            }
        }
        return count;
    }
}
