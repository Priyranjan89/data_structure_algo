package com.my.datastrcture.prectice.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses32 {

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
         return maxLen;
    }
}
