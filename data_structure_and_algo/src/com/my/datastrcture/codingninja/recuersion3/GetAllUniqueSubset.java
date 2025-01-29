package com.my.datastrcture.codingninja.recuersion3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllUniqueSubset {
    public static void main(String[] args) {
        int input[] = {1, 2, 2};
        printSubsets(input);
    }

    public static void printSubsets(int input[]) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(input);
        helper(0, input, subset, ans);

        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void helper(int i, int[] arr, List<Integer> subset, List<List<Integer>> ans) {
        if (i >= arr.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        helper(i + 1, arr, subset, ans);
        subset.remove(subset.size() - 1);
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        helper(i + 1, arr, subset, ans);
    }

    /*private static void generateUniqueSubsets(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset)); // Add current subset to result

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Add current element to the subset
            currentSubset.add(nums[i]);
            // Recursively generate subsets starting from the next index
            generateUniqueSubsets(nums, i + 1, currentSubset, subsets);
            // Backtrack
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

     private static int[][] generateUniqueSubsets(int[] nums) {
        // Count number of unique elements
        int uniqueCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                uniqueCount++;
            }
        }

        // Initialize 2D array to store subsets
        int[][] subsets = new int[(int) Math.pow(2, uniqueCount)][];
        int index = 0;

        // Generate subsets
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int[] subset = new int[Integer.bitCount(i)];
            int subsetIndex = 0;
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    if (j > 0 && nums[j] == nums[j - 1] && (i & (1 << (j - 1))) == 0) {
                        isValid = false; // Skip if not first occurrence of duplicate
                        break;
                    }
                    subset[subsetIndex++] = nums[j];
                }
            }
            if (isValid) {
                subsets[index++] = Arrays.copyOf(subset, subsetIndex);
            }
        }

        return Arrays.copyOf(subsets, index); // Trim the subsets array to remove unused space
    }
    */
}
