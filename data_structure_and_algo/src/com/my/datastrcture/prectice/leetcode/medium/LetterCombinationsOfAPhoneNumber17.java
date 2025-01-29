package com.my.datastrcture.prectice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {

    public static void main(String[] args) {
        String str ="23";
        List<String> ans = letterCombinations(str);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        StringBuilder output = new StringBuilder();
        int index = 0;

        solve(digits, output, index, ans);
        return ans;
    }

    private static void solve(String digit, StringBuilder output, int index, List<String> ans) {
        if (index == digit.length()) {
            ans.add(output.toString());
            return;
        }

        int number = digit.charAt(index) - '0';
        String value = mapping(number);

        for (int i = 0; i < value.length(); i++) {
            output.append(value.charAt(i));
            solve(digit, output, index + 1, ans);
            output.deleteCharAt(output.length() - 1);
        }
    }

    private static String mapping(int newNum){
        String str[] =  {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        return str[newNum];
    }
}
