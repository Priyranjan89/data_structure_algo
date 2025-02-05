package com.my.datastrcture.prectice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;
    public StackWithTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        q1.add(element);
        size++;
    }

    public int pop() {
        if (q1.isEmpty()){
            return -1;
        }
        while (q1.size() != 1){
            q2.add(q1.remove());
        }
        int temp = q1.remove();
        while (!q2.isEmpty()){
            q1.add(q2.remove());
        }
        size--;
        return temp;
    }

    public int top() {
        if (q1.isEmpty()){
            return -1;
        }
        while (q1.size() != 1){
            q2.add(q1.remove());
        }
        int top = q1.peek();
        q2.add(q1.remove());

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

        return top;
    }
}
