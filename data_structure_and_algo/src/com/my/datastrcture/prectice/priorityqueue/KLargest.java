package com.my.datastrcture.prectice.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargest {

    public static void main(String[] args) {
        int input[] = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k = 4;

        ArrayList<Integer> ans = kLargestBetter(input, k);
        for (int num : ans){
            System.out.print(num+" ");
        }
    }

    public static ArrayList<Integer> kLargest(int input[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++){
            pq.add(input[i]);
        }

        for (int i = k; i < input.length; i++){
            if (pq.peek() < input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }

    public static ArrayList<Integer> kLargestBetter(int[] input, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Traverse each element in the input array
        for (int num : input) {
            if (minHeap.size() < k) {
                // If heap has less than k elements, add the current number
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                // If the current number is larger than the smallest in the heap,
                // remove the smallest and add the current number
                minHeap.poll();
                minHeap.add(num);
            }
        }

        // Convert the heap into an ArrayList to return the k largest elements
        return new ArrayList<>(minHeap);
    }
}
