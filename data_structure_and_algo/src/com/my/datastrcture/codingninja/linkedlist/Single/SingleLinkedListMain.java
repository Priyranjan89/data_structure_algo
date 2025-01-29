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
      /*  int pos = 3;
        int data  = 100;
        head = SingleLinkedList.insert(head, pos, data);*/
        /*3 4 5 2 6 1 9 -1
        3 100*/

        /*int val = SingleLinkedList.findNode(head, 25);
        System.out.println(val);*/

        /*1 2 3 4 5 -1
          3
          10 20 30 40 50 60 -1
          5
         */

        int n = 5;
        head = SingleLinkedList.appendLastNToFirst(head, n);
        printLinkedList(head);


       // head = SingleLinkedList.removeDuplicates(head);
        //SingleLinkedList.printReverse(head);
        /*boolean isPalin =  SingleLinkedList.isPalindrome(head);
        System.out.println(isPalin);*/
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

    public static void printLinkedList(SinglyNode<Integer> head){
        System.out.println();
        SinglyNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


}
/*1
5 11 10 4 5 4 6 6 10 8 5 5 -1
29 35*/