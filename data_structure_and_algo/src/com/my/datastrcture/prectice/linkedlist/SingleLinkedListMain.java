package com.my.datastrcture.prectice.linkedlist;

import java.util.Scanner;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        SinglyNode<Integer> head = null;
        SinglyNode<Integer> head2 = null;
        SinglyNode<Integer> head3 = null;
        Pair<Integer> pair = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();

        while (value != -1){
            head = linkedList.insertNewNode(value);
          /*  head2 = linkedList.insertNewNodeWithHead(head2, value);
            pair = linkedList.insertNewNodeWithHeadAndTail(pair, value);
            head3 = pair.head;*/
            value = sc.nextInt();

        }
      /*  System.out.println("Please entre 2nd node value : ");
        int value2 = sc.nextInt();

        while (value2 != -1){
            head2 = linkedList.insertNewNodeWithHead(head2, value2);
            value2 = sc.nextInt();

        }*/
        linkedList.printLL(head);
        //linkedList.printLL(head2);
        /*linkedList.printLL(head2);
        linkedList.printLL(head3);
        System.out.println(pair.tail);
        System.out.println(pair.tail.data);*/
        System.out.println("Length Of Head = "+ linkedList.length(head));
        //linkedList.printIthNode(head,3);
       /* head = linkedList.insertNewNodeAtPosition(head, 20, 1);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/
       /* head = linkedList.deleteNode(head, 7);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/
       /* head = linkedList.deleteNodeWithData(head, 12);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/
        /*System.out.println("Please enter position to Append list : ");
        int pos = sc.nextInt();

        head = linkedList.appendLastNToFirstBetter(head, pos);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/

        /*head = linkedList.removeDuplicates(head);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/

        /*linkedList.printReverse(head);
        System.out.println();*/
/*
        SinglyNode<Integer> reverse = linkedList.reverseLLUsingRecursion(head);
        linkedList.printLL(reverse);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/


        /*SinglyNode<Integer> reverse = linkedList.reverseLL(head);
        linkedList.printLL(reverse);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/

        /*boolean isPalindrome = linkedList.isPalindrome(head);
        System.out.println("Linked List is Palindrome = "+isPalindrome);
        linkedList.printLL(head);*/

       /* head = linkedList.insertNodeAtPositionRecursively(head, 20, 7);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/

       /* head = linkedList.deleteNodeRecursively(head, 5);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/
        /*head = linkedList.reverseLLUsingRecursion(head);
        linkedList.printLL(head);
        System.out.println("Length Of Head = "+ linkedList.length(head));*/

        /*SinglyNode<Integer> margeHead = linkedList.margeTwoSortedList(head1, head2);
        linkedList.printLL(margeHead);
        System.out.println("Length Of Head = "+ linkedList.length(margeHead));*/

       /* SinglyNode<Integer> sortedList = linkedList.mergeSort(head);
        linkedList.printLL(sortedList);
        System.out.println("Length Of Head = "+ linkedList.length(sortedList));*/

        /*SinglyNode<Integer> oddEven = linkedList.evenAfterOdd(head);
        linkedList.printLL(oddEven);
        System.out.println("Length Of Head = "+ linkedList.length(oddEven));*/
        /*SinglyNode<Integer> mDeletesN = linkedList.skipMDeleteN(head, 2, 2);
        linkedList.printLL(mDeletesN);
        System.out.println("Length Of Head = "+ linkedList.length(mDeletesN));*/

        /*SinglyNode<Integer> swapNodes = linkedList.swapNodes(head, 0, 6);
        linkedList.printLL(swapNodes);
        System.out.println("Length Of Head = "+ linkedList.length(swapNodes));*/

        SinglyNode<Integer> swapNodes = linkedList.kReverse(head, 3);
        linkedList.printLL(swapNodes);
        System.out.println("Length Of Head = "+ linkedList.length(swapNodes));



    }

}
