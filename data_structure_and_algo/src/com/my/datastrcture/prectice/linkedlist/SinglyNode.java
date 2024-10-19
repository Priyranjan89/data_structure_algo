package com.my.datastrcture.prectice.linkedlist;

public class SinglyNode<T> {
    public T data;
    public SinglyNode<T> next;

    private SinglyNode(){}
    public SinglyNode(T data) {
        this.data = data;
        this.next = null;
    }
}
