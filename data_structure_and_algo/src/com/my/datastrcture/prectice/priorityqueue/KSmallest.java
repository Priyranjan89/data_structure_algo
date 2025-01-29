package com.my.datastrcture.prectice.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallest {
    public static void main(String[] args) {
        int input[] = {2,12,9,16,10,5,3,20,25,11,1,8,6};
        int k = 4;

        ArrayList<Integer> ans = kSmallest(input.length, input, k);
        for (int num : ans){
            System.out.print(num+" ");
        }
    }

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++){
            pq.add(input[i]);
        }
        for (int i = k; i < n; i++){
            if (pq.peek() > input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }

    public static ArrayList<Integer> kSmallestBetter(int n, int[] input, int k) {
        // Max-heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());

        // Process each element in the array
        for (int num : input) {
            if (maxHeap.size() < k) {
                // If the heap has less than k elements, add the current number
                maxHeap.add(num);
            } else if (num < maxHeap.peek()) {
                // If the heap has k elements and the current number is smaller than the root
                maxHeap.poll();  // Remove the largest of the k smallest elements
                maxHeap.add(num);  // Add the current number to the heap
            }
        }

        // Convert the heap into an ArrayList to return the k smallest elements
        return new ArrayList<>(maxHeap);
    }
}
