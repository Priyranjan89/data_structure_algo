package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.codingninja.linkedlist.Single.SinglyNode;
import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;

import java.util.Scanner;

public class ReverseLinkedListII92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();
        ListNode head = null;
        // 1 2 3 4 5 -1

        while (value != -1){
            head = LinkedListInsertNode.insertNewNodeWithHead(head, value);
            value = sc.nextInt();

        }

        int l = 2;
        int r = 4;

        printLikedList(head);

        ReverseLinkedListII92 rev = new ReverseLinkedListII92();

        head = rev.reverseBetween(head, l, r);
        printLikedList(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }
        ListNode current = head, prev = null, next= null;

        for (int i = 0; current != null && i < left-1; i++){
            prev = current;
            current = current.next;
        }

        ListNode leftNode = prev;
        ListNode newEnd = current;

        for (int i = 0; current != null && i<right-left+1; i++){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (leftNode != null){
            leftNode.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;

        return head;
    }

    private static void printLikedList(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
