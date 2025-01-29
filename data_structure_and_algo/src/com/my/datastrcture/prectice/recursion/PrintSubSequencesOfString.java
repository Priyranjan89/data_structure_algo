package com.my.datastrcture.prectice.recursion;

public class PrintSubSequencesOfString {
    public static void main(String[] args) {
        printSubsequences("abc");
    }
    public static void printSubsequences(String input) {
        printSubsequences(input, "");
    }

    private static void printSubsequences(String input, String ans) {
        if (input.length() == 0){
            System.out.println(ans);
            return;
        }
        printSubsequences(input.substring(1), ans);
        printSubsequences(input.substring(1), ans+input.charAt(0));
    }
}
