package com.my.datastrcture.leetcode.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null){
            return list1;
        }
        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        ListNode finalHead = null, tail = null;
        ListNode temp1 = list1, temp2 = list2;

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

}
