package com.my.datastrcture.codingninja.linkedlist.doublelinkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        DoublyNode head  = list.createDLL(10);

        list.print(head);
        System.out.println(list.size());

        list.insertAtTail( 20);
        list.print(head);

        list.insertAtTail( 30);
        list.print(head);

        list.insertAtTail( 40);
        list.print(head);

        list.insertAtTail( 50);
        list.print(head);

        head =  list.insertAtPosition(head,1, 5);
        list.print(head);

        head =  list.insertAtPosition(head,4, 25);
        list.print(head);

        head =  list.insertAtPosition(head,8, 70);
        list.print(head);
        System.out.println(list.tail.data);
        System.out.println(list.size());

        head =  list.deleteNode(head,1);
        list.print(head);
        System.out.println(list.size());

        head =  list.deleteNode(head,7);
        list.print(head);
        System.out.println(list.size());
        System.out.println(list.tail.data);

        head =  list.deleteNode(head,3);
        list.print(head);
        System.out.println(list.size());


    }
}
