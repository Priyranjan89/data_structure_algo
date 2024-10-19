package com.my.datastrcture.leetcode.medium;


import java.util.Scanner;

public class SortList148 {
    public static void main(String[] args) {
        SortList148 sort = new SortList148();
        Scanner sc = new Scanner(System.in);
        ListNode head =null;
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();

        while (value != -1){
            head = sort.insertNewNodeWithHead(head, value);
          /*  head2 = linkedList.insertNewNodeWithHead(head2, value);
            pair = linkedList.insertNewNodeWithHeadAndTail(pair, value);
            head3 = pair.head;*/
            value = sc.nextInt();

        }
        sort.printLL(head);

        ListNode headNode = sort.sortList(head);
        sort.printLL(headNode);

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode part1 = head;
        ListNode part2 = mid.next;
        mid.next = null;

        ListNode head1 = sortList(part1);
        ListNode head2 = sortList(part2);

        return margeSortedLL(head1, head2);

    }

    private ListNode margeSortedLL(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null){
            return head1;
        }
        if (head1 == null){
            return head2;
        }

        if (head2 == null){
            return head1;
        }

        ListNode finalHead = null, tail = null;
        ListNode temp1 = head1, temp2 = head2;

        if (temp1.val <= temp2.val){
            finalHead = temp1;
            tail = temp1;
            temp1 = temp1.next;
        } else {
            finalHead = temp2;
            tail = temp2;
            temp2 = temp2.next;
        }

        while (temp1 != null && temp2 != null){
            if (temp1.val <= temp2.val){
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null){
            tail.next = temp1;
        }else {
            tail.next = temp2;
        }

        return finalHead;
    }

    private ListNode getMid(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode insertNewNodeWithHead(ListNode head, int value){
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

    public void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

}
