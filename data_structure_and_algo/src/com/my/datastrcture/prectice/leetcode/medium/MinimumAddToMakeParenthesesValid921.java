package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid921 {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
