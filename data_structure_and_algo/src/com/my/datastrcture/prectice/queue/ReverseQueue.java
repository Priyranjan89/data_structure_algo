package com.my.datastrcture.prectice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
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
        if (input.size() <= 1){
            return;
        }

        int temp = input.poll();
        reverseQueue(input);
        input.add(temp);
    }

    private static void printQueue(Queue<Integer> input){
        for (int val : input){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
