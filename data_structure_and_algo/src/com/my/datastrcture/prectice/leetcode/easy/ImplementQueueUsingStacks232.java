package com.my.datastrcture.prectice.leetcode.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {

    }
}

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> helperStack;

    public MyQueue() {
        stack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (stack.empty()){
            return -1;
        }
        while (stack.size() != 1){
            helperStack.push(stack.pop());
        }
        int temp = stack.pop();

        while (!helperStack.empty()){
            stack.push(helperStack.pop());
        }
        return temp;
    }

    public int peek() {
        if (stack.empty()){
            return -1;
        }
        while (stack.size() != 1){
            helperStack.push(stack.pop());
        }
        int temp = stack.peek();

        while (!helperStack.empty()){
            stack.push(helperStack.pop());
        }
        return temp;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

