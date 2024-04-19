package com.my.datastrcture.codingninja.priorityqueue;

public class CustomPriorityQueueTest {
    public static void main(String[] args) throws Exception{
        CustomPriorityQueue<String> pq = new CustomPriorityQueue<>();

        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fsafsafa", 150);
        pq.insert("xvxzxvssa", 120);

        while(!pq.isEmpty()){
            System.out.println(pq.getMin());
            pq.removeMin();
        }
    }
}
