package com.my.datastrcture.prectice.stack;

import com.my.datastrcture.codingninja.stack.StackEmptyException;

public class StackWithLinkedList<T> {
    private Node<T> head;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T val){
        Node<T> node = new Node<>(val);
        node.next = head;
        head = node;
        size++;
    }

    public T top() throws StackEmptyException {
        if (head == null){
            throw new StackEmptyException("Stack is empty");
        }
        return head.data;
    }

    public T pop() throws StackEmptyException {
        if (head == null){
            throw new StackEmptyException("Stack is empty");
        } T data = head.data;
        head = head.next;
        size--;
        return data;
    }
}
