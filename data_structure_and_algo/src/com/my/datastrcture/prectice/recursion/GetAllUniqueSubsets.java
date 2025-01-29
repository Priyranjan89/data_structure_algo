package com.my.datastrcture.prectice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllUniqueSubsets {
    public static void main(String[] args) {
        int input[] = {1, 1, 2};
        printSubsets(input);
    }

    public static void printSubsets(int input[]) {
        List<List<Integer>> result = subsetsWithDup(input);
        for (List<Integer> lists : result){
            for (int num : lists){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, subset, ans);

        return ans;
    }

    private static void subsetsHelper(int[] input,
                                      int index,
                                      List<Integer> subset,
                                      List<List<Integer>> ans) {

        if (index == input.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(input[index]);
        subsetsHelper(input, index + 1, subset, ans);

        subset.remove(subset.size()-1);
        while (index+1 < input.length && input[index] == input[index+1]){
            index++;
        }
        subsetsHelper(input, index + 1, subset, ans);
    }
}
