package com.my.datastrcture.codingninja.linkedlist.doublelinkedlist;

public class DoublyNode {

    public int data;
    public DoublyNode prev;
    public DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public DoublyNode(int data, DoublyNode prev, DoublyNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }
}
