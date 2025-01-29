package com.my.datastrcture.prectice.recursion;

import java.util.ArrayList;

public class ReturnPermutation {
    public static void main(String[] args) {
        //String output[] = permutations("abc");
        String output[] = permutations2("abc");
        for (String str : output){
            System.out.println(str);
        }
    }
    public static String[] permutations(String input) {
        return permutationsHelper(input, "");
    }

    private static String[] permutationsHelper(String input, String ans) {
        if (input.length() == 0) {
            return new String[]{ans};  // Base case: return an array with the single permutation
        }

        String[] result = new String[0];  // Initialize an empty result array

        for (int i = 0; i < input.length(); i++) {
            String smallInput = input.substring(0, i) + input.substring(i + 1);
            String[] partialResult = permutationsHelper(smallInput, ans + input.charAt(i));  // Recursive call

            // Create a new array with enough space for the current results and partial results
            String[] newResult = new String[result.length + partialResult.length];

            // Manually copy elements from result to newResult
            for (int j = 0; j < result.length; j++) {
                newResult[j] = result[j];
            }

            // Manually copy elements from partialResult to newResult
            for (int j = 0; j < partialResult.length; j++) {
                newResult[result.length + j] = partialResult[j];
            }

            result = newResult;  // Update result to include new permutations
        }
        return result;
    }

    public static String[] permutations2(String input){
        ArrayList<String> result = new ArrayList<>();
        permutationsHelper2(input, "", result);
        return result.toArray(new String[0]);
    }

    private static void permutationsHelper2(String input, String ans, ArrayList<String> result){
        if (input.length() == 0){
            result.add(ans);
            return;
        }
        for (int i = 0; i < input.length(); i++){
            String smallInput = input.substring(0, i) + input.substring(i+1);
            permutationsHelper2(smallInput, ans + input.charAt(i), result);
        }
    }
}
