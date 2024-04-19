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
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<String>(), a, 0);
        return ans;
    }

    private static void helper(List<List<String>> ans, ArrayList<String> temp, String a, int idx) {
        if (idx == a.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<a.length(); i++) {
            String sb = a.substring(idx, i+1);

            if (isPalindrome(sb)) {
                temp.add(sb);
                helper(ans, temp, a, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
