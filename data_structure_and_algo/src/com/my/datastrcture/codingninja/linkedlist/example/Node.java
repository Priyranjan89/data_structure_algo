package com.my.datastrcture.codingninja.linkedlist.example;

public class Node<T> {

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
    }
}
