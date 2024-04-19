package com.my.datastrcture.codingninja.priorityqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTheTicket {
    public static void main(String[] args) {
        int input[] = {2, 3, 2, 2, 4};
        System.out.println(buyTicket(input, 3));
    }

    public static int buyTicket(int input[], int k) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            queue.add(i);
            pq.add(input[i]);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            if (input[queue.peek()] < pq.peek()) {
                queue.add(queue.poll());
            } else {
                int idx = queue.poll();
                pq.remove();
                time++;
                if (idx == k) {
                    break;
                }
            }
        }
        return time;
    }
}
