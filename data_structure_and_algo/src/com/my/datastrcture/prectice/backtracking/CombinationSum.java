package com.my.datastrcture.prectice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] ARR = {1, 2, 3};
        int B = 5;

        List<List<Integer>> result = combSum(ARR, B);

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public static List<List<Integer>> combSum(int[] ARR, int B) {
        List<List<Integer>> result = new ArrayList<>();  // To store all valid combinations
        List<Integer> combination = new ArrayList<>();  // To store the current combination being built

        Arrays.sort(ARR);  // Sort the array to ensure non-decreasing order

        // Start the backtracking process
        findCombinations(ARR, B, 0, combination, result);

        return result;
    }

    private static void findCombinations(int[] ARR, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        // Base Case: If target becomes 0, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(combination)); // Create a new copy of the combination
            return;
        }

        // Loop through the array starting from the given index
        for (int i = index; i < ARR.length; i++) {
            if (ARR[i] > target) {
                // If the current element is greater than the remaining target, no need to proceed
                break;
            }

            // Choose the current element
            combination.add(ARR[i]);

            // Recur with reduced target and same index (to allow repetition of elements)
            findCombinations(ARR, target - ARR[i], i, combination, result);

            // Backtrack: Remove the last added element to explore other possibilities
            combination.remove(combination.size() - 1);
        }
    }

}
