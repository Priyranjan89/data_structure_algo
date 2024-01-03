package com.my.datastrcture.linkedList.course;

public class CircularDoubleLinkedListMain {

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCDLL(10);
        cdll.insertDLL(20, 1);
        cdll.insertDLL(30, 2);
        cdll.insertDLL(40, 3);
        cdll.insertDLL(5,0);
        cdll.traverseCDLL();

        cdll.insertDLL(50,5);
        cdll.traverseCDLL();
        cdll.reverseTraverseCDLL();
        cdll.searchDLL(30);

        cdll.insertDLL(35,4);
        cdll.traverseCDLL();

        cdll.deleteNodeCDll(0);
        cdll.traverseCDLL();

        cdll.deleteNodeCDll(6);
        cdll.traverseCDLL();

        cdll.deleteNodeCDll(3);
        cdll.traverseCDLL();

        cdll.deleteCDLL();
        cdll.traverseCDLL();
    }
}
