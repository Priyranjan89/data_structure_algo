package com.my.datastrcture.prectice.priorityqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueQuestion {
    public static void main(String[] args) {
        int input[] = {2, 3, 2, 2, 4};
        System.out.println(buyTicket(input, 3));
    }
    public static boolean checkMaxHeap(int arr[]) {

        int n = arr.length;
        for (int i = 0; i < n; i++){
            if ((2*i)+1 < n && arr[i] < arr[(2*i)+1]){
                return false;
            }
            if ((2*i)+2 < n && arr[i] < arr[(2*i)+2]){
                return false;
            }
        }
        return true;
    }

    public static int kthLargest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++){
            pq.add(input[i]);
        }

        for (int i = k; i < n; i++){
            if (input[i] > pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }
        return pq.peek();
    }

    public static int buyTicket(int[] input, int k) {
        // Initialize the queue to store persons with their priorities and index
        Queue<int[]> queue = new LinkedList<>();
        // Max-heap (priority queue) to store priorities in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Populate the queue and the max-heap with initial priorities
        for (int i = 0; i < input.length; i++) {
            queue.add(new int[]{input[i], i});
            maxHeap.add(input[i]);
        }

        int time = 0;  // Initialize the time counter

        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            int priority = person[0];
            int index = person[1];

            // Check if the current person's priority is the highest
            if (priority == maxHeap.peek()) {
                // Give ticket to the current person
                time++;
                maxHeap.poll();  // Remove the highest priority from the max-heap

                // If this is the target person, return the time
                if (index == k) {
                    return time;
                }
            } else {
                // Otherwise, move the person to the end of the queue
                queue.add(person);
            }
        }

        return time;  // This line will never be reached in the current problem constraints
    }
}
