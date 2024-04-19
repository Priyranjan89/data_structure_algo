package com.my.datastrcture.codingninja.stack.question;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        int arr[] = {1, 2, 3, 4, 5, 10};
        for (int n : arr){
            input.push(n);
            System.out.print(n+" ");
        }
        System.out.println();
        Stack<Integer> extra = new Stack<>();
        reverseStack(input, extra);

        while (!input.isEmpty()){
            System.out.print(input.pop()+" ");
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
        if (input.size() == 0){
            return;
        }

        int temp = input.pop();
        reverse(input, extra);
        extra.push(temp);
    }
}
