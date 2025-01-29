package com.my.datastrcture.prectice.recursion;

import java.util.ArrayList;

public class PrintSubSetSumK {

    public static void main(String[] args) {
        int input[] = {5,12,3,17,1,18,15,3,17};
        int k = 6;
        printSubsetsSumTok(input, k);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTokHelper(input, k , new int[0], 0);
    }

    private static void printSubsetsSumTokHelper(int input[], int k, int output[], int startIndex) {
        if (startIndex == input.length){
            if (k == 0){
                for (int num : output){
                    System.out.print(num+" ");
                }
                System.out.println();
                return;
            } else {
                return;
            }
        }

        int newOutput[] = new int[output.length+1];
        int i;
        for (i = 0; i < output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = input[startIndex];
        printSubsetsSumTokHelper(input, k, output, startIndex+1);
        printSubsetsSumTokHelper(input, k - input[startIndex], newOutput, startIndex+1);

    }
   /* public static void printSubsetsSumTok(int input[], int k) {
        // Start the recursion from index 0 with an empty subset
        findSubsets(input, k, 0, new ArrayList<>());
    }

    private static void findSubsets(int[] input, int k, int index, ArrayList<Integer> subset) {
        // Base case: if we've reached the end of the array
        if (index == input.length) {
            // Check if the sum of elements in subset equals k
            int sum = 0;
            for (int num : subset) {
                sum += num;
            }
            if (sum == k) {
                // Print the subset if the sum equals k
                for (int num : subset) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }

        // Recursive case:
        // Include the current element in the subset
        subset.add(input[index]);
        findSubsets(input, k, index + 1, subset);

        // Backtrack: Remove the last element to exclude it
        subset.remove(subset.size() - 1);
        findSubsets(input, k, index + 1, subset);
    }*/
}
