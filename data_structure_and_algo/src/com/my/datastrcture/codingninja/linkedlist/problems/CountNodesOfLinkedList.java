package com.my.datastrcture.codingninja.linkedlist.problems;


public class CountNodesOfLinkedList {

    public static PNode createLinkedList(){
        //3 4 5 2 6 1 9 -1
        PNode PNode1 = new PNode(3);
        PNode PNode2 = new PNode(4);
        PNode PNode3 = new PNode(5);
        PNode PNode4 = new PNode(2);
        PNode PNode5 = new PNode(6);
        PNode PNode6 = new PNode(1);
        PNode PNode7 = new PNode(9);
        PNode PNode8 = new PNode(-1);
        PNode1.next = PNode2;
        PNode2.next = PNode3;
        PNode3.next = PNode4;
        PNode4.next = PNode5;
        PNode5.next = PNode6;
        PNode6.next = PNode7;
        PNode7.next = PNode8;
        return PNode1;
    }

    public static int length(PNode head){
        int size = 1;

        if (head == null){
            return 0;
        }
        PNode temp = head;
        while (head.next != null){
            if (temp.data != -1){
                size++;
            }
            temp = temp.next;
        }
        return size;
    }


    public static void main(String[] args) {
        PNode head = new PNode();
        head = createLinkedList();
        int length = length(head);
        System.out.println(length);
    }
}
