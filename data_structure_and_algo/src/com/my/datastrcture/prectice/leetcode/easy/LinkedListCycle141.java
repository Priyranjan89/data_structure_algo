package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.medium.ListNode;
import com.my.datastrcture.prectice.linkedlist.SinglyNode;

import java.util.Scanner;

public class LinkedListCycle141 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();
        ListNode head = null;
        // 1 2 3 4 5 6 7 8 -1

        while (value != -1){
            head = LinkedListInsertNode.insertNewNodeWithHead(head, value);
            value = sc.nextInt();

        }
        ListNode temp = head;
        ListNode cycleNode = head;
        int data = 4;
        while(temp.next != null){
            if (temp.val == data){
                cycleNode = temp;
            }
            temp = temp.next;
        }

        temp.next = cycleNode;

        System.out.println(hasCycle(head));
        System.out.println();
        System.out.println("Length of Cycle Linked List : "+cycleLength(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null){
            return false;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public static int cycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null){
            return 0;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode temp = slow.next;
                int count = 1;
                while (temp != slow){
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return -1;
    }
}
