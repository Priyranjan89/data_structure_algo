package com.my.datastrcture.prectice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates); // Sort the array to handle duplicates properly
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void dfs(int[] ARR, int remainingSum, int start, List<Integer> current) {
        if (remainingSum < 0) {
            return;
        }
        if (remainingSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < ARR.length; i++) {
            current.add(ARR[i]);
            dfs(ARR, remainingSum - ARR[i], i, current); // Allow choosing the same number again
            current.remove(current.size() - 1);
        }
    }
}
