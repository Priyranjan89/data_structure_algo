package com.my.datastrcture.codingninja.priorityqueue;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int input[] = {9,4,8,7,11,3};
        System.out.println(kthLargest(input.length, input, 2));
    }

    public static int kthLargest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }

        for(int i=k;i<input.length;i++)
        {
            int minVal=pq.peek();
            if(minVal<input[i])
                minVal=input[i];
            if(minVal!=pq.peek())
            {
                pq.poll();
                pq.add(minVal);
            }
        }

        int minVal=Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int check=pq.poll();
            if(check<minVal)
                minVal=check;
        }
        return minVal;
    }
}
