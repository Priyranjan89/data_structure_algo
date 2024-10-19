package com.my.datastrcture.prectice.stack;

import com.my.datastrcture.codingninja.stack.StackEmptyException;
import com.my.datastrcture.codingninja.stack.StackFullException;

import java.util.Stack;

public class StackWithArray {
    private int data[];
    private int topIndex;

    public StackWithArray(int size){
        data = new int[size];
        topIndex = -1;
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public int size(){
        return topIndex+1;
    }

    public void push(int val) throws StackFullException {
        if (topIndex == data.length-1){
            doubleCapacity();
        }
        data[++topIndex] = val;
    }

    public int top() throws StackEmptyException {
        if (topIndex == -1){
            throw new StackEmptyException("Stack is Empty");
        }

        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if (topIndex == -1){
            throw new StackEmptyException("Stack is Empty");
        }

        int temp = data[topIndex];
        topIndex--;
        return temp;
    }

    public static boolean isBalanced(String expression) {
        if (expression.length() == 0){
            return true;
        }
        char charArr[] = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : charArr){
            if ((ch == '[') || (ch == '{') || (ch == '(')){
                stack.push(ch);
            } else if ((ch == ']') || (ch == '}') || (ch == ')')){
                if ((!stack.isEmpty()) &&
                        ((stack.peek() == '[' && ch == ']') ||
                        (stack.peek() == '{' && ch == '}') ||
                        (stack.peek() == '(' && ch == ')') )){
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

    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
       if (input.isEmpty()){
           return;
       }
       int temp = input.pop();
       reverse(input, extra);

       input.push(temp);
       while (!extra.isEmpty()){
           input.push(extra.pop());
       }
    }

    private static void reverse(Stack<Integer> input, Stack<Integer> extra){
        if (input.isEmpty()){
            return;
        }
        int temp = input.pop();
        reverse(input, extra);
        extra.push(temp);
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }

}
