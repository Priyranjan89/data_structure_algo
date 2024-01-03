package com.my.datastrcture.linkedList.node;

public class SingleNode {

    public int value;
    public SingleNode next;

    public SingleNode(){}

    public SingleNode(int value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
