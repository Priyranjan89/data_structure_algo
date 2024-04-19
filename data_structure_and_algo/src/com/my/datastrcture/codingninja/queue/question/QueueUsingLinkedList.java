package com.my.datastrcture.codingninja.queue.question;


public class QueueUsingLinkedList {

    private Node front;
    private Node rear;
    private int size;
    public QueueUsingLinkedList() {
       front = null;
       rear = null;
       size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
       return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void enqueue(int data) {
        Node node = new Node(data);
        if (rear == null){
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }


    public int dequeue() {
        if (size == 0){
            return -1;
        }

        Node temp = front;
        if (size == 1){
            rear = null;
        }
        front = front.next;
        size --;

        return temp.data;
    }


    public int front() {
        if (size == 0){
            return -1;
        }
        return front.data;
    }
}
