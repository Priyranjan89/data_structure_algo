package com.my.datastrcture.prectice.queue;

import com.my.datastrcture.codingninja.queue.QueueEmptyException;
import com.my.datastrcture.prectice.stack.Node;

public class QueueWithLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueWithLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException("Queue is empty");
        }
        T temp = front.data;
        if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        size--;
        return temp;
    }

    public T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException("Queue is empty");
        }
        return front.data;
    }

}
