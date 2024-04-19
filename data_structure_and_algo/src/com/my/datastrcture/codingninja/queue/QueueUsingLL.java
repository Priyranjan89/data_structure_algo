package com.my.datastrcture.codingninja.queue;

import com.my.datastrcture.codingninja.linkedlist.example.Node;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (size == 0){
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }


    public T dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException("Queue is empty");
        }

        T temp = front.data;
        if (size == 1){
            rear = null;
            front = null;
        } else {
            front = front.next;
        }
        size --;

        return temp;
    }


    public T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException("Queue is empty");
        }
       return front.data;
    }
}
