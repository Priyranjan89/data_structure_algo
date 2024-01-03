package com.my.datastrcture.linkedList.course;

import com.my.datastrcture.linkedList.node.DoublyNode;

public class CircularDoubleLinkedList {

    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode createCDLL(int nodeValue){
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = newNode;
        newNode.pre = newNode;
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
            createCDLL(nodeValue);
            return;
        } else if (location == 0){
            newNode.pre = tail;
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
            tail.next = newNode;
        } else if (location >= size){
            newNode.next = head;
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            head.pre = newNode;
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

    public void traverseCDLL() {
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

    public void reverseTraverseCDLL() {
        if (head == null) {
            System.out.println("Double LinkedList doesn't exist!!!");
            return;
        } else {
            DoublyNode tempNode = tail;
            for (int i = 0; i <size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
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
    public void deleteNodeCDll(int location){
        if (head == null) {
            System.out.println("Double LinkedList doesn't exist!!!");
            return;
        } else if (location == 0){
            if (size == 1){
                head.pre = null;
                head.next = null;
                head = tail = null;
            } else {
                head = head.next;
                head.pre = tail;
                tail.next = head;
            }
            size--;
        } else if (location >= size){
            DoublyNode tempNode = tail.pre;
            if (size == 1){
                head.pre = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tempNode;//tail.pre;
                tail.next = head;
                head.pre = tail;
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

    public void deleteCDLL(){
        DoublyNode tempNode = head;
        for (int i = 0; i < size-1; i++){
            tempNode.pre = null;
            tempNode = tempNode.next;
        }

        tail.next = null;
        head = null;
        tail = null;
        System.out.println("DoublyLinkedList has been deleted...");
    }
}
