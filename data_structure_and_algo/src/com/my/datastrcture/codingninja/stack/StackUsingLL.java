package com.my.datastrcture.codingninja.stack;

import com.my.datastrcture.codingninja.linkedlist.example.Node;

/*public class Node<T> {

    public T data;
    public Node next;

    public Node(){}

    public Node(T data) {
        this.data = data;
        this.next = next;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }*/
public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    public StackUsingLL(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        /*if (head == null){
            return true;
        }
        return false;*/
        return head == null;
    }

    public void push(T element){
        Node<T> node = new Node<>(element);
        node.next = head;
        head = node;
        size++;
    }

    public T top() throws StackEmptyException {
        if (head == null){
            throw new StackEmptyException("Stack is Empty");
        }
        return head.data;
    }

    public T pop() throws StackEmptyException {
        if (head == null){
            throw new StackEmptyException("Stack is Empty");
        }

        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}
