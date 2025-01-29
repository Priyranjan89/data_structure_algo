package com.my.datastrcture.prectice.leetcode.medium;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null ){
            return head;
        }
        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;

        while (head != null){
            if (head.val %2 == 0){
                if (evenHead == null && evenTail == null){
                    evenHead = head;
                    evenTail= head;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            } else {
                if (oddHead == null && oddTail == null){
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            }
            head = head.next;
        }

        if (oddHead != null){
            oddTail.next = evenHead;
        }else {
            return evenHead;
        }

        if (evenHead != null){
            evenTail.next = null;
        }
        return oddHead;
    }


}
