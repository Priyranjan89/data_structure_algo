package com.my.datastrcture.codingninja.linkedlist.Single;

public class SinglyNode<T> {

    public T data;
    public SinglyNode<T> next;

    public SinglyNode(){}

    public SinglyNode(T data) {
        this.data = data;
    }

    public SinglyNode(T data, SinglyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
