package com.my.datastrcture.codingninja.queue;

public class QueueUse {
    public static void main(String[] args) throws Exception {
        QueueUsingArray queue = new QueueUsingArray(2);

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        int arr[] = {10, 20, 30, 40, 50};
        for (int val : arr){
            queue.enQueue(val);
        }

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        while (!queue.isEmpty()){
            try {
                System.out.println(queue.deQueue());
            } catch (QueueEmptyException e) {
                System.out.println(e.getMessage());
            }
        }

        /*queue.enQueue(60);
        System.out.println(queue.front());
        System.out.println(queue.deQueue());
        queue.enQueue(70);
        System.out.println(queue.front());*/
        System.out.println(queue.size());

    }
}
