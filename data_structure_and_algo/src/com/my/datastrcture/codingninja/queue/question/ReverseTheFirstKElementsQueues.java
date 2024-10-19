package com.my.datastrcture.codingninja.queue.question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseTheFirstKElementsQueues {
    public static void main(String[] args) {
        Queue<Integer> input = new LinkedList<>();
        int arr[] = {1,2,3,4,5,10};
        for (int val : arr){
            input.add(val);
        }
        int k = 3;
        printQueue(input);
        Queue<Integer> ans = reverseKElements(input, k);
        printQueue(ans);
    }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        //Your code goes here
        if (input.isEmpty() || input.size() < k) {
            return input;
        }
        if (k <= 0 ) {
            return input;
        }

        Stack<Integer> stack = new Stack<>();
        for (int  i = 0; i < k; i++){
            stack.push(input.poll());
        }

        while (!stack.isEmpty()){
            input.add(stack.pop());
        }

        for (int i = 0; i < input.size()-k; i++){
            input.add(input.poll());
        }
        return input;
    }

    public static Queue<Integer> reverseKElements1(Queue<Integer> input, int k) {
        //Your code goes here
        if (input.size() > k) {
            k = k % input.size();
        }
        if (k == 0 || k == 1) {
            return input;
        }

        reverseQueue(input, k);

        for (int i = 0; i < input.size() - k; i++) {
            input.add(input.remove());
        }

        return input;

    }

    public static void reverseQueue(Queue<Integer> input, int k) {
        //Your code goes here
        if (input.size() == 0 || input.size() == 1 || k == 0) {
            return;
        }

        int temp = input.remove();
        reverseQueue(input, k - 1);
        input.add(temp);
    }

    private static void printQueue(Queue<Integer> input){
        for (int val : input){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
