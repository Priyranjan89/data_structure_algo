package com.my.datastrcture.codingninja.recuersion3.test;

import java.util.ArrayList;
import java.util.List;

public class ReturnPermutationsString {
    public static void main(String[] args) {
        String input = "abc";
        //String ans[] = permutationOfString(input);
        String ans[] = permutationOfStringBest(input);
        for (int i =0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
        System.out.println("\n");
        List<String> permutations = permutationOfStringBetter(input);
        for (String permutation : permutations){
            System.out.println(permutation);
        }
    }

    public static String[] permutationOfString(String input){

        if (input.length() == 0) {
            String ans[] = {""};
            return ans;
        }
        String[] ans = permutationOfString(input.substring(1));
        String output[] = new String[ans.length * input.length()];

        int k = 0;
        for (int i = 0; i < ans.length;i++){
            for (int j = 0 ; j <= ans[i].length(); j++){
                output[k++] = ans[i].substring(0, j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        return output;
    }

    public static String[] permutationOfStringBest(String input){
        if (input.length() == 0){
            String ans[] = {""};
            return ans;
        }
        ArrayList<String> permutations = new ArrayList<>();

        for (int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            String smallInput = input.substring(0,i) + input.substring(i+1);
            String smallAns[] = permutationOfStringBest(smallInput);

           for (String str : smallAns){
               permutations.add(currentChar+str);
           }
        }
        return permutations.toArray(new String[0]);
    }

    public static List<String> permutationOfStringBetter(String input){
        if (input.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> permutations = new ArrayList<>();

        List<String> smallAns=null;
        for (int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            String smallInput = input.substring(0,i) + input.substring(i+1);
            smallAns = permutationOfStringBetter(smallInput);

            for (String str : smallAns){
                permutations.add(currentChar+str);
            }
        }
        return permutations;
    }
}
