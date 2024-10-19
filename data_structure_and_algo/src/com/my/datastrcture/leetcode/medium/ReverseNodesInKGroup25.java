package com.my.datastrcture.leetcode.medium;

import com.my.datastrcture.prectice.linkedlist.SinglyNode;

public class ReverseNodesInKGroup25 {
    public ListNode reverseKGroup1(ListNode head, int k) {

        if (k == 0 || k == 1) {
            return head;
        }
        ListNode currentNode = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        while (count < k && currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKGroup1(next, k);
        }
        return prev;
    }

    ListNode reverse2(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode Next = head;
        while (curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        ListNode temp = head;
        int size = 1;
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        ListNode Next = null;

        while (temp != null) {
            if (size == k) {
                Next = temp.next;

                temp.next = null;
                ListNode newHeads = reverse2(head);
                t.next = newHeads;
                t = head;
                head = Next;
                temp = Next;
                size = 1;
            } else {
                size++;
                temp = temp.next;
            }
        }
        if (Next != null) {
            t.next = Next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode preTail = null;        // stores the tail node of previous LL.
        ListNode curHead = head;        // stores the head node of current LL
        ListNode curTail = head;        // stores the tail node of current LL

        ListNode nextHead = null;       // stores the head node of next LL

        while (curHead != null) {
            // initialize count from 1
            int count = 1;

            // iterate the LL untill count becomes k or we reach the last node.
            while (curTail.next != null && count < k) {
                curTail = curTail.next;
                count++;
            }

            if (count != k) {
                break;
            }

            // set the nextHead pointer to the head of the next LL.
            nextHead = curTail.next;

            // detach the RHS of the current LL.
            curTail.next = null;

            // detach the LHS of the current LL.
            if (preTail != null) {
                preTail.next = null;
            }
            // after reversing the current LL, curHead becomes the new tail.
            // and curTail becomes the new head.

            curTail = reverse(curHead);

            // attach the LHS
            if (preTail != null) {
                preTail.next = curTail;
            } else {
                // if preTail is null then we have reversed the first LL
                // so store the reference of curHead in original head pointer.
                head = curTail;
            }

            // attach the RHS
            curHead.next = nextHead;

            // update the pointer
            preTail = curHead;
            curHead = nextHead;
            curTail = nextHead;
        }

        return head;

    }

    private ListNode reverse(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;

        ListNode nextNode = head;

        while (curNode != null) {
            nextNode = nextNode.next;

            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

}
