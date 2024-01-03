package com.my.datastrcture.linkedList.example;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createLL(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(2);
        ll.insertNode(6);
        ll.insertNode(5);
        ll.insertNode(7);
        ll.insertNode(6);
        ll.insertNode(3);
        ll.insertNode(5);

        ll.traversLL();

        RemoveDuplicate rd = new RemoveDuplicate();
        rd.deleteDuplicate(ll);
        ll.traversLL();
    }
}
