package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;

import java.util.Scanner;

public class RotateList61 {
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
        RotateList61 r = new RotateList61();
        head = r.rotateRight(head, 2);
        printLikedList(head);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null){
            return head;
        }
        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null){
            length++;
            lastNode = lastNode.next;
        }

        lastNode.next = head;
        int rotation = k % length;
        int skip = length - rotation;
        ListNode newLast = head;

        for (int i = 0; i < skip-1; i++){
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

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
