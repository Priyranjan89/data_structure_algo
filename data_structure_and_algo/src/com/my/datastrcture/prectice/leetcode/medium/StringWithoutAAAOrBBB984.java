package com.my.datastrcture.prectice.leetcode.medium;

public class StringWithoutAAAOrBBB984 {

    public static void main(String[] args) {
        StringWithoutAAAOrBBB984 solution = new StringWithoutAAAOrBBB984();

        // Test cases
        int[][] testCases = {
                {1, 2},  // Expected: "abb", "bab", or "bba"
                {4, 1},  // Expected: "aabaa"
                {5, 3},  // Expected: "aabbaabb"
                {0, 4},  // Expected: "bbbb"
                {4, 4},  // Expected: "abababab"
                {10, 1}, // Expected: "aabaaabaaa"
        };

        for (int[] testCase : testCases) {
            int a = testCase[0];
            int b = testCase[1];
            String result = solution.strWithout3a3b(a, b);
            System.out.println("Input: a = " + a + ", b = " + b);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            int length = result.length();
            boolean writeA = false;

            if (length >= 2 && result.charAt(length - 1) == result.charAt(length - 2)) {
                if (result.charAt(length - 1) == 'a') {
                    writeA = false;  // Last two are "aa", so add 'b'
                } else {
                    writeA = true;   // Last two are "bb", so add 'a'
                }
            } else {
                writeA = (a >= b); // Prefer the letter with higher count
            }

            if (writeA) {
                result.append('a');
                a--;
            } else {
                result.append('b');
                b--;
            }
        }

        return result.toString();
    }
    public String strWithout3a3bDetails(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            int len = result.length();
            boolean writeA = false;

            // Step 1: Prevent "AAA" or "BBB"
            if (len >= 2 && result.charAt(len - 1) == result.charAt(len - 2)) {
                if (result.charAt(len - 1) == 'a') {
                    writeA = false;  // Last two are "aa", so we must add 'b'
                } else {
                    writeA = true;   // Last two are "bb", so we must add 'a'
                }
            }
            // Step 2: Prefer the character with a higher remaining count
            else {
                writeA = (a >= b);  // If 'a' is greater or equal to 'b', add 'a'
            }

            // Step 3: Append the chosen character and decrease its count
            if (writeA) {
                result.append('a');
                a--;
            } else {
                result.append('b');
                b--;
            }
        }

        return result.toString();
    }
}
