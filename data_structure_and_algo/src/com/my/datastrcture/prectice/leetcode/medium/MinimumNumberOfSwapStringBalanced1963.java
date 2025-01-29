package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Stack;

public class MinimumNumberOfSwapStringBalanced1963 {
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '['){
                stack.push(ch); //
            } else if (!stack.isEmpty() && stack.peek() == '['){
                stack.pop(); // Removed Balanced Pairs
            } else {
                stack.push(ch);
            }
        }
        int unBalancedPairs = stack.size() / 2;
        int ans = (int) Math.ceil(unBalancedPairs / 2.0);

        return ans;
    }

    public static int minSwapsBetter(String s) {
        int imbalance = 0, maxImbalance = 0;

        // Iterate through the string to calculate the maximum imbalance
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // Decrease imbalance as `[` can balance a previous `]`
                imbalance--;
            } else {
                // Increase imbalance as `]` needs a matching `[`
                imbalance++;
            }

            // Track the maximum imbalance
            maxImbalance = Math.max(maxImbalance, imbalance);
        }

        // Each swap fixes two units of imbalance
        return (maxImbalance + 1) / 2;
    }
}
