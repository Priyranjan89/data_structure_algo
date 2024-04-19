package com.my.datastrcture.codingninja.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElements {
    public static void main(String[] args) {
        int input[] = {2,12,9,16,10,5,3,20,25,11,1,8,6};
        int k = 4;

        ArrayList<Integer> ans = kSmallest(input.length, input, k);
        for (int num : ans){
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }

        for(int i=k;i<input.length;i++)
        {
            int maxVal=pq.peek();
            if(maxVal>input[i])
                maxVal=input[i];
            if(maxVal!=pq.peek())
            {
                pq.poll();
                pq.add(maxVal);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!pq.isEmpty())
            arr.add(pq.poll());

        Collections.sort(arr);
        return arr;
    }
}
