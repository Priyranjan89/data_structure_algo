package com.my.datastrcture.codingninja.linkedlist.problems;

public class PNode {
    public int data;
    public PNode next;

    PNode()
    {
        this.data = 0;
        this.next = null;
    }

    PNode(int data)
    {
        this.data = data;
        this.next = null;
    }

    PNode(int data, PNode next)
    {
        this.data = data;
        this.next = next;
    }
}
