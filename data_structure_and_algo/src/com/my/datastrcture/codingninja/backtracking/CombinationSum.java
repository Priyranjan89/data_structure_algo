package com.my.datastrcture.codingninja.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] ARR = {2, 3, 5};
        int B = 8;
        List<List<Integer>> combinations = combSum(ARR, B);
        if (isValid(combinations, B)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates); // Sort the array to handle duplicates properly
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public static List<List<Integer>> combSum(int[] ARR, int B) {
        result = new ArrayList<>();
        if (ARR == null || ARR.length == 0) {
            return result;
        }
        Arrays.sort(ARR); // Sort the array to handle duplicates properly
        dfs(ARR, B, 0, new ArrayList<>());
        return result;
    }

    public static void dfs(int[] ARR, int remainingSum, int start, List<Integer> current) {
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

    public static boolean isValid(List<List<Integer>> combinations, int B) {
        for (List<Integer> combination : combinations) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }
            if (sum != B) {
                return false;
            }
        }
        return true;
    }
}
