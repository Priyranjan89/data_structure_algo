package com.my.datastrcture.prectice.recursion;

public class PrintPermutation {
    public static void main(String[] args) {
        permutations("abc");
    }

    public static void permutations(String input){
        permutationsHelper(input, "");
    }

    private static void permutationsHelper(String input, String ans){
        if (input.length() == 0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < input.length(); i++){
            String smallInput = input.substring(0, i) + input.substring(i+1);
            permutationsHelper(smallInput, ans + input.charAt(i));
        }
    }
}
