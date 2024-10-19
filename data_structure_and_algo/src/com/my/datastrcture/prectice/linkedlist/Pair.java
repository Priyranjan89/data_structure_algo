package com.my.datastrcture.prectice.linkedlist;

public class Pair<T> {
    public SinglyNode<T> head;
    public SinglyNode<T> tail;

    public Pair(){}

    public Pair(SinglyNode<T> head, SinglyNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

}
