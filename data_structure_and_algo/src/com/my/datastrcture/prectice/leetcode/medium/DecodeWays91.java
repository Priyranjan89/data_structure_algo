package com.my.datastrcture.prectice.leetcode.medium;

import java.util.ArrayList;

public class DecodeWays91 {
    public static void main(String[] args) {
        String s = "111111111111111111111111111111111111111111111";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings1(String s) {
        ArrayList<String> codes = new ArrayList<>();
        generateCodes(s, "", codes);
        return codes.size();
    }
    private static void generateCodes(String input, String currentCodes, ArrayList<String> codes) {
        // Base Case: If input is empty, add the current code to the list
        if (input.length() == 0){
            codes.add(currentCodes);
            return;
        }
        // Take the first digit and map it to a character
        int firstDigit = input.charAt(0) - '0';
        if (firstDigit >= 1 && firstDigit <= 9){
            char firstChar = (char) ('a' + firstDigit - 1);
            generateCodes(input.substring(1), currentCodes + firstChar, codes);
        }
        if (firstDigit == 0){
            generateCodes(input.substring(1), currentCodes, codes);
        }

        // If possible, take the first two digits and map them to a character
        if (input.length() >= 2){
            int firstTwoDigit = Integer.parseInt(input.substring(0, 2));
            if (firstTwoDigit >= 10 && firstTwoDigit <= 26){
                char secondChar = (char) ('a' + firstTwoDigit - 1);
                generateCodes(input.substring(2), currentCodes + secondChar, codes);
            }
        }
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= twoDigits && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
