package com.my.datastrcture.prectice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SubSetsOfArray78 {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> susets = subsets(arr);
        for (List<Integer> lists : susets){
            for (int num: lists){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        return helper(nums, index, output, ans);
    }

    private static List<List<Integer>> helper(int[] nums,
                                               int index,
                                               List<Integer> output,
                                               List<List<Integer>> ans){

        if (index == nums.length){
            ans.add(new ArrayList<>(output));
            return ans;
        }

        // add the current element to the subset and recursively call the helper function with the next index
        output.add(nums[index]);
        helper(nums, index+1, output, ans);

        // remove the last element from the subset and recursively call the helper function with the next index
        output.remove(output.size()-1);
        helper(nums, index+1, output, ans);

        return ans;
    }
}
