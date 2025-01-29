package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.easy.LinkedListInsertNode;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNodeInLinkedList1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre 1st node value : ");
        int value = sc.nextInt();
        ListNode head = null;
        // 2 1 5 -1

        while (value != -1){
            head = LinkedListInsertNode.insertNewNodeWithHead(head, value);
            value = sc.nextInt();

        }
        int ans[] = nextLargerNodes(head);
        for (int num : ans){
            System.out.println(num+" ");
        }
    }
    public static int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        int arr[] = new int[len];
        for (int i = 0; i < arr.length && head != null; i++){
            arr[i] = head.val;
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; ++i){
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int child = stack.peek();
                stack.pop();
                ans[child] = arr[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
