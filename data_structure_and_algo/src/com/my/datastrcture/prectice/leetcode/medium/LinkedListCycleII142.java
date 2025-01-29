package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;

import java.util.Scanner;

public class LinkedListCycleII142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();
        ListNode head = null;
        // 1 2 3 4 5 6 7 8 9 -1

        while (value != -1){
            head = LinkedListInsertNode.insertNewNodeWithHead(head, value);
            value = sc.nextInt();

        }
        ListNode temp = head;
        ListNode cycleNode = head;
        int data = 5;
        while(temp.next != null){
            if (temp.val == data){
                cycleNode = temp;
            }
            temp = temp.next;
        }

        temp.next = cycleNode;
        ListNode node = detectCycle(head);
        System.out.println(node.val+" "+node);
        System.out.println("------------------------------Better---------------------------");
        ListNode node1 = detectCycleBetter(head);
        System.out.println(node.val+" "+node1);
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        int length = 0;

        if(head == null || head.next == null){
            return null;
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
                length = count;
                break;
            }
        }

        if (length == 0){
            return null;
        }

        //find the start node
        ListNode first = head;
        ListNode second = head;

        while (length > 0){
            second = second.next;
            length--;
        }

        while (first != second){
            first = first.next;
            second = second.next;
        }
        return second;
    }


    public static ListNode detectCycleBetter(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null){
            return null;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
