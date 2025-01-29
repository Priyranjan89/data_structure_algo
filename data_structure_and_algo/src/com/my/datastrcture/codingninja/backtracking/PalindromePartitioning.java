package com.my.datastrcture.codingninja.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> ans = partition("BaaB");
        for (List<String> list : ans){
            for (String  str : list){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String a) {
        // To store all valid partitions
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), a, 0);
        return ans;
    }

    private static void helper(List<List<String>> ans, ArrayList<String> temp, String a, int idx) {
        if (idx == a.length()) {
            // Add the current partition to the result
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < a.length(); i++) {
            String sb = a.substring(idx, i + 1); // Extract substring from idx to i

            if (isPalindrome(sb)) { // Check if it's a palindrome
                temp.add(sb); // Add the palindrome to the current partition
                helper(ans, temp, a, i + 1); // Recur for the remaining string
                temp.remove(temp.size() - 1); // Backtrack to explore other partitions
            }
        }
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
