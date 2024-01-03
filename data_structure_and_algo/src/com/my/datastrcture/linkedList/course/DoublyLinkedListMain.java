package com.my.datastrcture.linkedList.course;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(10);
        dll.insertDLL(20, 1);
        dll.insertDLL(30, 2);
        dll.insertDLL(40, 3);
        dll.traverseDLL();

        dll.insertDLL(5,0);
        dll.traverseDLL();

        dll.insertDLL(50,5);
        dll.traverseDLL();
        dll.reverseTraverseDLL();
        dll.searchDLL(30);

        dll.insertDLL(35,4);
        dll.traverseDLL();


        dll.deleteNodeDll(0);
        dll.traverseDLL();

        dll.deleteNodeDll(6);
        dll.traverseDLL();

        dll.deleteNodeDll(3);
        dll.traverseDLL();

        dll.deleteDLL();
        dll.traverseDLL();


    }
}
