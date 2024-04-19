package com.my.datastrcture.codingninja.linkedlist.Single;

import java.util.Scanner;

public class LinkedListMain {

    public static SinglyNode<Integer> createLinkedList(){
        //3 4 5 2 6 1 9 -1
        SinglyNode<Integer> singlyNode1 = new SinglyNode<>(3);
        SinglyNode<Integer> singlyNode2 = new SinglyNode<>(4);
        SinglyNode<Integer> singlyNode3 = new SinglyNode<>(5);
        SinglyNode<Integer> singlyNode4 = new SinglyNode<>(2);
        SinglyNode<Integer> singlyNode5 = new SinglyNode<>(6);
        SinglyNode<Integer> singlyNode6 = new SinglyNode<>(1);
        SinglyNode<Integer> singlyNode7 = new SinglyNode<>(9);
        SinglyNode<Integer> singlyNode8 = new SinglyNode<>(-1);
        singlyNode1.next = singlyNode2;
        singlyNode2.next = singlyNode3;
        singlyNode3.next = singlyNode4;
        singlyNode4.next = singlyNode5;
        singlyNode5.next = singlyNode6;
        singlyNode6.next = singlyNode7;
        singlyNode7.next = singlyNode8;
        return singlyNode1;
    }

    public static void increment(SinglyNode<Integer> head){
        SinglyNode<Integer> temp = head;
        while (temp != null){
            temp.data++;
            temp = temp.next;
        }
    }

    public static void printLinkedList(SinglyNode<Integer> head){
        SinglyNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void printIthNode(SinglyNode<Integer> head, int i){
        if(head == null || i < 0){
            return;
        }
        int idx = 0;

        SinglyNode<Integer> temp = head;
        while (temp != null){
            if (idx == i){
                System.out.println(temp.data);
            }
            temp = temp.next;
            idx++;
        }
    }

   /* public static Node<Integer> insert(Node<Integer> head, int pos, int data){
        Node<Integer> node  = new Node<>(data);
        Node<Integer> temp = head;


    }*/

    public static SinglyNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        SinglyNode<Integer> head = null;

        while (value != -1){
            SinglyNode<Integer> currentSinglyNode = new SinglyNode<>(value);
            if (head == null){
                head = currentSinglyNode;
            } else {
                SinglyNode<Integer> tail = head;
                while (tail.next != null){
                    tail = tail.next;
                }
                tail.next = currentSinglyNode;
            }
            value = sc.nextInt();
        }

        return head;
    }


    public static void main(String[] args) {
        /*Node<Integer> node = new Node<>(10);
        System.out.println(node.data+" "+node.next);
        Node<Integer> node1 = new Node<>(20);
        System.out.println(node1.data+" "+node1.next);
        node.next = node1;
        System.out.println(node.data+" "+node.next);
        System.out.println(node.data+" "+node.next.data+" "+node.next.next);*/

        SinglyNode<Integer> head = takeInput();
        printLinkedList(head);
        /*increment(head);
        printLinkedList(head);*/
        //printIthNode(head, 3);
    }
}
