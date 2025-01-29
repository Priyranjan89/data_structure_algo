package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;

import java.util.Scanner;

public class ReorderList143 {
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
        ReorderList143 r = new ReorderList143();
        r.reorderList(head);
        printLikedList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = getMid(head);
        ListNode reversHead = reverseList(mid);

        int index = 1;
        ListNode tail = head, temp = head.next;

        while (temp != null && reversHead != null){
            if (index % 2 == 0){
                tail.next = temp;
                tail = temp;
                temp = temp.next;
            } else {
                tail.next = reversHead;
                tail = reversHead;
                reversHead = reversHead.next;
            }
            index++;
        }

    }

    private ListNode getMid(ListNode head){
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);

        ListNode tail = head.next;
        tail.next = head;
        head.next = null;

        return newHead;
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
