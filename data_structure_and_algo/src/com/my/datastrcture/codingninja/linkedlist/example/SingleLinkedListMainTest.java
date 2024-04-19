package com.my.datastrcture.codingninja.linkedlist.example;

import java.util.Scanner;

public class SingleLinkedListMainTest {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        Node<Integer> head = null;

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        //inserting value at head position
        /*head = list.insertAtHead(head, 20);
        head = list.insertAtHead(head, 30);
        list.printLinkedList(head);*/
        while (data != -1){
            head = list.insertAtTail(head, data);
            data = sc.nextInt();
        }

        list.printLinkedList(head);

        /*head = list.insert(head, 3, 100);
        list.printLinkedList(head);*/

        head = list.deleteNode(head, 6);
        list.printLinkedList(head);
    }
}
