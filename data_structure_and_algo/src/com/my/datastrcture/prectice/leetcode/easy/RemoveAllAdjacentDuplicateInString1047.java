package com.my.datastrcture.prectice.leetcode.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicateInString1047 {
    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (stack.isEmpty()){
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (top == ch){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        String ans = "";
        while (!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public String removeDuplicatesBetter(String s) {
        char[] arr = s.toCharArray();
        int i = -1;
        for(char ch : arr) {
            if(i >= 0 && arr[i] == ch) {
                --i;
            }
            else {
                arr[++i] = ch;
            }
        }
        return String.valueOf(arr,0,i+1);
    }
}
