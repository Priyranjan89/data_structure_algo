package com.my.datastrcture.codingninja.linkedlist.doublelinkedlist;

public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public void print(DoublyNode head){
        DoublyNode temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    public DoublyNode createDLL(int data){
        DoublyNode node = new DoublyNode(data);
        head = node;
        tail = node;
        size++;
        return head;
    }

    public DoublyNode insertAtHead(int data){
        if (head == null){
            return createDLL(data);
        } else {
            DoublyNode node = new DoublyNode(data);
            node.next = head;
            head.prev = node;
            head = node;
            size++;

            return head;
        }

    }

    public DoublyNode insertAtTail(int data){
        DoublyNode node = new DoublyNode(data);
        tail.next = node;
        node.prev = tail;

        tail = node;
        size++;

        return tail;
    }

    public DoublyNode insertAtPosition(DoublyNode head, int position, int data) {

        //insert at Start

        if(position == 1) {
            head = insertAtHead(data);
            return head;
        }

        DoublyNode temp  = head;
        int cnt = 1;

        while(cnt < position-1) {
            if (temp.next == null){
                return head;
            }
            temp = temp.next;
            cnt++;
        }

        //inserting at Last Position
        if(temp.next == null) {
            insertAtTail(data);
            return head;
        }

        //creating a node for data
        DoublyNode nodeToInsert = new DoublyNode(data);

        nodeToInsert.next = temp.next;
        temp.next.prev = nodeToInsert;
        temp.next = nodeToInsert;
        nodeToInsert.prev = temp;
        size++;
        return head;
    }

    public DoublyNode deleteNode(DoublyNode head, int position) {

        //deleting first or start node
        if (position == 1) {
            DoublyNode temp = head;
            temp.next.prev = null;
            head = temp.next;
            temp.next = null;
            size--;
            return head;

        } else {
            //deleting any middle node or last node
            DoublyNode curr = head;
            DoublyNode prev = null;

            int cnt = 1;
            while (cnt < position) {
                prev = curr;
                if (curr.next == null){
                    return head;
                }
                curr = curr.next;
                cnt++;
            }

            curr.prev = null;
            prev.next = curr.next;
            curr.next = null;
            tail = prev;
            if (prev.next != null){
                prev.next.prev = prev;
            }

            size--;
            return head;
        }
    }

}
