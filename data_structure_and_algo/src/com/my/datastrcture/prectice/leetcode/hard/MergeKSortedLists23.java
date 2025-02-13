package com.my.datastrcture.prectice.leetcode.hard;

import com.my.datastrcture.prectice.leetcode.medium.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists23 {
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode head = null;
        ListNode tail = null;

        // Add first node of each list into the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Merge lists
        while (!pq.isEmpty()) {
            ListNode front = pq.poll();

            if (head == null) {
                head = front;
                tail = front;
            } else {
                tail.next = front;
                tail = front;
            }

            if (tail.next != null) {
                pq.offer(tail.next);
            }
        }

        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store the ListNode objects based on their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Initialize the heap with the first node of each list
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode head = null, tail = null;

        // Process the min-heap
        while (!pq.isEmpty()) {
            ListNode front = pq.poll();

            // Insert into the merged linked list
            if (head == null) {
                head = tail = front;
            } else {
                tail.next = front;
                tail = front;
            }

            // If the next node exists, add it to the heap
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        MergeKSortedLists23 solution = new MergeKSortedLists23();
        ListNode mergedHead = solution.mergeKLists(lists);
        printList(mergedHead);
    }
}
