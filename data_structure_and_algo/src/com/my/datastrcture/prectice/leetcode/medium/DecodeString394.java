package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Stack;

public class DecodeString394 {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;


        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                n = n * 10 + (ch - '0');
            } else if (ch == '['){
                intStack.push(n);
                n = 0;
                strStack.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']'){
                int k = intStack.pop();
                StringBuilder temp = sb;
                sb = strStack.pop();
                while (k > 0){
                    sb.append(temp);
                    k--;
                }
            } else {
                sb.append(ch);
            }
        }
           return sb.toString();
    }
}
