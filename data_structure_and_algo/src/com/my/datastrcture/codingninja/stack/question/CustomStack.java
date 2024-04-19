package com.my.datastrcture.codingninja.stack.question;


public class CustomStack {
    private Node head;
    private int size;


    public CustomStack() {
        head = null;
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int element) {
        Node node = new Node(element);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if (head == null){
            return -1;
        }

        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public int top() {
        if (head == null){
            return -1;
        }
        return head.data;
    }
}
