package com.my.datastrcture.codingninja.recuersion3;

public class PrintSubSequences {
    public static void main(String[] args) {
        String input = "abc";
       printSubsequences(input);
    }

    public static void printSubsequences(String input) {
        printSubsequencesHelper(input, "");
    }

    private static void printSubsequencesHelper(String input, String ans) {
        if (input.length() == 0){
            System.out.println(ans);
            return;
        }
        printSubsequencesHelper(input.substring(1), ans);
        printSubsequencesHelper(input.substring(1), ans+input.charAt(0));
    }

   /* public static void printSubsequences(String input) {
        printSubsequencesHelper(input, "");
    }
    public static void printSubsequencesHelper(String input, String ans) {
        if (input.length() == 0){
            System.out.println(ans);
            return;
        }
        printSubsequencesHelper(input.substring(1), ans);
        printSubsequencesHelper(input.substring(1), ans+input.charAt(0));
    }*/

}
