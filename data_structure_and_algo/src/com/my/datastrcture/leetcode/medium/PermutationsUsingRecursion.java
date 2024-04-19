package com.my.datastrcture.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsUsingRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = permute(nums);
        for (List<Integer> lists : ans){
            for (int num: lists){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i =0; i < nums.length; i++){
            output.add(nums[i]);
        }
        int index =0;
        solve(output, ans, index);

        return ans;
    }

    private static void solve(List<Integer> nums, List<List<Integer>> ans, int index){
        if (index >= nums.size()){
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int j = index; j < nums.size(); j++){
            swap(nums, index, j);
            solve(nums, ans, index+1);
            swap(nums, index, j);
        }
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i,  arr.get(j));
        arr.set(j, temp);
    }
}
