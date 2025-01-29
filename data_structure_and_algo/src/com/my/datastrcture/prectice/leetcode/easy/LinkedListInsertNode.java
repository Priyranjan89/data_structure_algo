package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.medium.ListNode;

public class LinkedListInsertNode {
    public static ListNode insertNewNodeWithHead(ListNode head, int value){
        if (head == null){
            return new ListNode(value);
        } else {
            ListNode node = new ListNode(value);

            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;

            return head;
        }
    }
}
