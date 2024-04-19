package com.my.datastrcture.codingninja.stack.question;

import java.util.Stack;

public class MinimumBracketReversal {
    public static void main(String[] args) {
        String input = "{{{{}}";
        System.out.println(countBracketReversals(input));
    }

    public static int countBracketReversals(String input) {
        if (input.length() == 0){
            return 0;
        }
        if (input.length() % 2 == 1){
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            if (ch == '{'){
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        //Stack contain invalid expression
        int a = 0, b = 0;
        while (!stack.isEmpty()){
            if (stack.peek() == '{') {
                b++;
            } else {
                a++;
            }
            stack.pop();
        }

        int ans = (a+1)/2 + (b+1)/2;

        return ans;
    }

}
