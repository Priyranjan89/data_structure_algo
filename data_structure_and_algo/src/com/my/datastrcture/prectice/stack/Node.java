package com.my.datastrcture.prectice.stack;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data){
        this.data = data;
        next = null;
    }
}
