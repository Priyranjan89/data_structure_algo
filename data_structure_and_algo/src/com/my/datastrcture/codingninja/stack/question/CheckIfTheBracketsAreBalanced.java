package com.my.datastrcture.codingninja.stack.question;

import java.util.Stack;

public class CheckIfTheBracketsAreBalanced {
    public static void main(String[] args) {
        //String expression = "[{()}()]";
        String expression = "[{(()}]";
        System.out.println(isBalanced(expression));
    }

    public static boolean isBalanced(String expression) {
        if (expression.length() == 0){
            return true;
        }
        char chArr[] = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char ch : chArr){
            if (ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')'){
                if (!stack.isEmpty()
                        && ((stack.peek() == '[' && ch == ']')
                        || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '(' && ch == ')'))){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
