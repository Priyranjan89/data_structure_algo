package com.my.datastrcture.codingninja.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int input[] = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k = 4;

        ArrayList<Integer> ans = kLargest(input, k);
        for (int num : ans){
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i=k; i<input.length;i++){
            if(pq.peek()<input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
