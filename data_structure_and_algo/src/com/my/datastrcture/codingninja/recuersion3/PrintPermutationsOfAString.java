package com.my.datastrcture.codingninja.recuersion3;

public class PrintPermutationsOfAString {
    public static void main(String[] args) {
        String input = "abc";
        permutations(input);
    }
    public static void permutations(String input){
        permutationsHelper(input, "");
    }
    public static void permutationsHelper(String input, String ans){
        if (input.length() == 0){
            System.out.println(ans);
        }
        for (int i = 0; i < input.length(); i++){
            String smallerString = input.substring(0, i) + input.substring(i+1);
            permutationsHelper(smallerString, ans + input.charAt(i));
        }
    }
}
