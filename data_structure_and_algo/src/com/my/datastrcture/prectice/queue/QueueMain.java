package com.my.datastrcture.prectice.queue;

import com.my.datastrcture.codingninja.queue.QueueEmptyException;

public class QueueMain {
    public static void main(String[] args) throws QueueEmptyException {
        QueueWithArray queue = new QueueWithArray();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        int arr[] = {10, 20, 30, 40};
        for (int val : arr){
            queue.enQueue(val);
        }
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.front());

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.enQueue(50);

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.front());


    }
}
