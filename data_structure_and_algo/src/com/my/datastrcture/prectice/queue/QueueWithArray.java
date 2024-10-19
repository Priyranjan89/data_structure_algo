package com.my.datastrcture.prectice.queue;

import com.my.datastrcture.codingninja.queue.QueueEmptyException;

public class QueueWithArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueWithArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueWithArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enQueue(int val){
        if (size == data.length){
            doubleCapacity();
        }
        if (size == 0){
            front = 0;
        }
       /* rear++;
        if (rear == data.length){
            rear = 0;
        }*/

        rear = (rear + 1) % data.length;
        data[rear] = val;
        size++;
    }

    public int front() throws QueueEmptyException {
        if (front == -1){
            throw new QueueEmptyException("Queue empty");
        }
        return data[front];
    }

    public int deQueue() throws QueueEmptyException{
        if (front == -1){
            throw new QueueEmptyException("Queue empty");
        }

        int temp = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        int index = 0;

        for (int i = front; i < temp.length; i++){
            data[index++] = temp[i];
        }

        for (int i = 0; i < front-1; i++){
            data[index++] = temp[i];
        }

        front = 0;
        rear = temp.length-1;
    }
}
