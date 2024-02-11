package com.my.datastrcture.codingninja.recursion.hard;

public class ReturnPermutationsString {
    public static void main(String[] args) {
        String input = "abc";
        String ans[] = permutationOfString(input);
        for (int i =0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }

    public static String[] permutationOfString(String input){

        if (input.length() == 0) {
            String y[] = {""};
            return y;
        }
        String[] ans = permutationOfString(input.substring(1));
        String output[] = new String[ans.length * input.length()];

        int k = 0;
        for (int i = 0; i < ans.length; i++) {

            for (int j = 0; j <= ans[i].length(); j++) {
                output[k++] = ans[i].substring(0, j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        return output;
    }
}
