package com.my.datastrcture.codingninja.linkedlist.Single;

import java.util.Scanner;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        SinglyNode<Integer> head = null;
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        while (value != -1){
            head = list.insertNode(value);
            value = sc.nextInt();
        }

        list.printLinkedList();
        System.out.println("\n");
       /* int pos = 29;
        int data  = 35;
        head = SingleLinkedList.insert(head, pos, data);*/

        /*int val = SingleLinkedList.findNode(head, 25);
        System.out.println(val);*/

       /* int n = 3;
        head = SingleLinkedList.appendLastNToFirst(head, n);*/

       // head = SingleLinkedList.removeDuplicates(head);
        //SingleLinkedList.printReverse(head);
        boolean isPalin =  SingleLinkedList.isPalindrome(head);
        System.out.println(isPalin);
/*
        int pos = 10;
        head = SingleLinkedList.deleteNode(head, pos);*/
/*
        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();*/


    }
}
/*1
5 11 10 4 5 4 6 6 10 8 5 5 -1
29 35*/