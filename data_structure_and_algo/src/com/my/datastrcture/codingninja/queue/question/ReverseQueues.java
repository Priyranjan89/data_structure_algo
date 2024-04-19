package com.my.datastrcture.codingninja.queue.question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueues {
    public static void main(String[] args) {
        //1 2 3 4 5 10
        Queue<Integer> input = new LinkedList<>();
        int arr[] = {1,2,3,4,5,10};
        for (int val : arr){
            input.add(val);
        }
        printQueue(input);
        reverseQueue(input);
        printQueue(input);
    }

    public static void reverseQueue(Queue<Integer> input) {
        Stack<Integer> stack = new Stack<>();
        while (!input.isEmpty()){
            stack.push(input.remove());
        }

        while (!stack.isEmpty()){
            input.add(stack.pop());
        }
    }

    private static void printQueue(Queue<Integer> input){
        for (int val : input){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
