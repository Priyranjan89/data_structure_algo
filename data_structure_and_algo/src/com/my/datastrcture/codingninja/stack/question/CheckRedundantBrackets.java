package com.my.datastrcture.codingninja.stack.question;

import java.util.Stack;

public class CheckRedundantBrackets {
    public static void main(String[] args) {
        //String expression = "a+(b)+c";
        String expression = "a+b+c";
        System.out.println(checkRedundantBrackets(expression));
    }

    public static boolean checkRedundantBrackets(String expression) {

        if (expression.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i =0; i < expression.length(); i++){
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                stack.push(ch);
            } else {
                boolean isRedundant = true;
                if (ch == ')'){
                    while (stack.peek() != '('){
                        char top = stack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/'){
                            isRedundant = false;
                        }
                        stack.pop();
                    }
                    if (isRedundant == true){
                        return true;
                    }
                    stack.pop();
                }
            }
        }
        return false;
    }
}
