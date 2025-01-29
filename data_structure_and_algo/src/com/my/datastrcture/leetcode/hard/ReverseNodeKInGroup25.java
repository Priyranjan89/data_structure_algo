package com.my.datastrcture.leetcode.hard;

import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;
import com.my.datastrcture.prectice.leetcode.medium.ListNode;

import java.util.Scanner;

public class ReverseNodeKInGroup25 {
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
        printLikedList(head);
        ReverseNodeKInGroup25 r = new ReverseNodeKInGroup25();
        head = r.reverseKGroup(head, 2);
        printLikedList(head);
    }
    // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    public int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1){
            return head;
        }
        int index = 0;
        ListNode temp = head;
        while (temp != null && index < k){
            temp = temp.next;
            index++;
        }
        if (index != k){
            return head;
        }

        ListNode currentNode = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 1;

        while (count <= k && currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            count++;
        }
        if (next != null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
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
