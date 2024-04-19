package com.my.datastrcture.linkedList.course;

import com.my.datastrcture.linkedList.node.DoublyNode;

public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode createDLL(int nodeValue){
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.pre = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    //Insertion method
    public void insertDLL(int nodeValue, int location){
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null){
            createDLL(nodeValue);
            return;
        } else if (location == 0){
            newNode.pre = null;
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        } else if (location >= size){
            newNode.next = null;
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index =0;
            while (index < location-1){
                tempNode = tempNode.next;
                index++;
            }
            newNode.pre = tempNode;
            newNode.next = tempNode.next;
            tempNode.next.pre = newNode;
            tempNode.next = newNode;
        }
        size++;
    }

    public void traverseDLL() {
        if (head == null) {
            System.out.println("Double LinkedList doesn't exist!!!");
            return;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    public void reverseTraverseDLL() {
        if (head == null) {
            System.out.println("Double LinkedList doesn't exist!!!");
            return;
        } else {
            DoublyNode tempNode = tail;
            for (int i = size-1; i >=0; i--) {
                System.out.print(tempNode.value);
                if (i != 0) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.pre;
            }
        }
        System.out.println("\n");
    }

    public boolean searchDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    //Deletion method
    public void deleteNodeDll(int location){
        if (head == null) {
            System.out.println("Double LinkedList doesn't exist!!!");
            return;
        } else if (location == 0){
            if (size == 1){
                head = tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.pre = null;
                size--;
            }
        } else if (location >= size){
            DoublyNode tempNode = tail.pre;
            if (size == 1){
                head = tail = null;
                size--;
                return;
            } else {
                tail = tempNode;//tail.pre;
                tail.next = null;
                size--;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location-1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.pre = tempNode;
            size--;
        }
    }

    public void deleteDLL(){
        DoublyNode tempNode = head;
        for (int i = 0; i < size-1; i++){
            tempNode.pre = null;
            tempNode = tempNode.next;
        }

        head = null;
        tail = null;
        System.out.println("DoublyLinkedList has been deleted...");
    }
}
