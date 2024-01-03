package com.my.datastrcture.linkedList.example;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue){
        Node newNode = new Node();
        newNode.next = null;
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int nodeValue){
        Node newNode = new Node();
        newNode.next = null;
        newNode.value = nodeValue;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traversLL(){
        Node tempNode = head;
        for (int i =0; i<size; i++){
            System.out.print(tempNode.value);
            if (i != size-1){
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }
}
