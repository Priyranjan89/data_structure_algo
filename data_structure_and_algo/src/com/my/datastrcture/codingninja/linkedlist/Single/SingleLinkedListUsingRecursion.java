package com.my.datastrcture.codingninja.linkedlist.Single;

import java.util.Scanner;

public class SingleLinkedListUsingRecursion<T> {

    public SinglyNode<T> head;
    public SinglyNode<T> tail;
    public int size;

    Scanner sc = new Scanner(System.in);

    public SinglyNode<T> createNode(T value){
        SinglyNode<T> singlyNode = new SinglyNode<>(value);
        head = singlyNode;
        tail = singlyNode;
        size = 1;
        return head;
    }

    public SinglyNode<Integer> insertNode(){
        int value = sc.nextInt();
        if (value == -1){
            return null;
        }

        SinglyNode<Integer> head = new SinglyNode<>(value);

        SinglyNode<Integer> afterSinglyNode = insertNode();
        head.next = afterSinglyNode;

        return head;
    }

    public SinglyNode<Integer> insertR(SinglyNode<Integer> head, int data, int pos){

        if(head == null && pos > 0){
            return head;
        }
        if (pos == 0){
            SinglyNode<Integer> singlyNode = new SinglyNode<>(data);
            singlyNode.next = head;
           return singlyNode;
        } else {
            head.next= insertR(head.next, data, pos-1);
            return head;
        }
    }

    public SinglyNode<Integer> deleteNodeRec(SinglyNode<Integer> head, int pos) {
        if(head.next == null && pos > 0){
            return head;
        }
        if (pos == 0){

            head = head.next;
            return head;
        } else {
            head.next= deleteNodeRec(head.next, pos-1);
            return head;
        }
    }

    public SinglyNode<Integer> reverseRec(SinglyNode<Integer> head) {
        if (head == null || head.next == null){
            return head;
        }

        SinglyNode<Integer> smallHead = reverseRec(head.next);
        SinglyNode<Integer> tail = smallHead;

        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;

        return smallHead;

    }

    public static DoubleN reverseRBetter(SinglyNode<Integer> head){
        DoubleN ans;
        if(head==null || head.next ==null){
            ans= new DoubleN(head, head);
            //ans.head= head;
            //ans.tail= head;
            return ans;
        }

        DoubleN smallAns= reverseRBetter(head.next);
        smallAns.tail.next= head;
        head.next= null;
        ans = new DoubleN();
        ans.head= smallAns.head;
        ans.tail= head;
        return ans;
    }

    public static int findNodeRec(SinglyNode<Integer> head, int n) {
       return  findNodeRec(head, n, 0);

    }

    public static int findNodeRec(SinglyNode<Integer> head, int n, int index) {
        if(head == null){
            return -1;
        }
        if (head.data == n){
            return index;
        }
        index = index + 1;

        return findNodeRec(head.next, n, index);
    }

    public SinglyNode<Integer> reverseRBeast(SinglyNode<Integer> head) {
        if (head == null || head.next == null){
            return head;
        }
        SinglyNode<Integer> smallHead = reverseRBeast(head.next);
        SinglyNode<Integer> reverseTail = head.next;
        reverseTail.next = head;
        head.next = null;

        return smallHead;
    }

    public static SinglyNode<Integer> mergeSort(SinglyNode<Integer> head) {
        if (head == null || head.next == null){
            return head;
        }

        SinglyNode<Integer> midSinglyNode = midPoint(head);
        SinglyNode<Integer> part1 = head;
        SinglyNode<Integer> part2 = midSinglyNode.next;
        midSinglyNode.next = null;

        SinglyNode<Integer> head1 = mergeSort(part1);
        SinglyNode<Integer> head2 = mergeSort(part2);

        return mergeTwoSorteds(head1, head2);
    }

    public static SinglyNode<Integer> midPoint(SinglyNode<Integer> head) {
        if (head == null || head.next == null){
            return head;
        }
        SinglyNode<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static SinglyNode<Integer> mergeTwoSorteds(SinglyNode<Integer> head1, SinglyNode<Integer> head2){

        if (head1 == null && head2 == null){
            return head1;
        }

        if (head1 == null){
            return head2;
        }

        if (head2 == null){
            return head1;
        }
        SinglyNode<Integer> temp1 = head1, temp2 = head2;
        SinglyNode<Integer> finalHead= null, tail=null;

        if(temp1.data <= temp2.data){
            finalHead=temp1;
            tail=temp1;
            temp1=temp1.next;
        }else{
            finalHead= temp2;
            tail=temp2;
            temp2=temp2.next;
        }

        while (temp1 != null && temp2 != null){
            if (temp1.data <= temp2.data){
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

    public static SinglyNode<Integer> evenAfterOdd(SinglyNode<Integer> head) {
        if (head == null){
            return head;
        }
        SinglyNode<Integer> oddHead = null, oddTail = null, evenHead = null, evenTail = null;

        while (head != null){
            if (head.data % 2 == 0){
                if (evenHead == null && evenTail == null){
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = head;

                }
                head = head.next;
            } else {
                if (oddHead == null && oddTail == null){
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
                head = head.next;
            }
        }

        if (oddHead != null){
            oddTail.next = evenHead;
        } else {
            return evenHead;
        }

        if (evenHead != null){
            evenTail.next = null;
        }

        return oddHead;
    }

    public static SinglyNode<Integer> skipMdeleteN(SinglyNode<Integer> head, int M, int N) {
        if (head == null){
            return head;
        }
        if (M == 0){
            return null;
        }
        if (N == 0){
            return head;
        }
        SinglyNode<Integer> curr = head, temp;
        int count;
        while (curr != null){
            for (count = 1; count < M && curr !=null; count++){
                curr = curr.next;
            }
            if ( curr == null){
                return head;
            }

            temp = curr.next;
            for (count = 1; count <= N && temp != null; count++){
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
        return head;
    }

    public static SinglyNode<Integer> swapNodes(SinglyNode<Integer> head, int i, int j) {
        if (head == null){
            return head;
        }

        SinglyNode<Integer> temp = head, prev = null, curr1 = null, curr2 = null, prev1 = null, prev2 = null;
        int pos = 0;
        while (temp != null) {
            if (pos == i) {
                prev1 = prev;
                curr1 = temp;
            }
            if (pos == j) {
                prev2 = prev;
                curr2 = temp;
            }
            prev = temp;
            temp = temp.next;
            pos++;
        }
        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }
        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }
        SinglyNode<Integer> temp1 = curr2.next;
        curr2.next = curr1.next;
        curr1.next = temp1;

        return head;
    }

    public static SinglyNode<Integer> kReverse(SinglyNode<Integer> head, int k) {
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        if(k==0)
            return head;
        SinglyNode<Integer> h1=head,h2,t1=head;
        int count=1;
        while(count<k && t1.next!=null)
        {
            t1=t1.next;
            count++;
        }

        h2=t1.next;
        t1.next=null;


        DoubleN ans=reversePart(h1);
        SinglyNode<Integer> secondHead=kReverse(h2,k);
        ans.tail.next=secondHead;
        return ans.head;

    }
    private static DoubleN reversePart(SinglyNode<Integer> head)
    {
        if(head==null || head.next==null)
        { DoubleN ans=new DoubleN();
            ans.head=head;
            ans.tail=head;
            return ans;
        }

        DoubleN ans=reversePart(head.next);
        ans.tail.next=head;
        head.next=null;
        ans.tail=ans.tail.next;
        return ans;
    }

    public static SinglyNode<Integer> bubbleSort(SinglyNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        for (int i = 0; i < lengthLL(head) - 1; i++) {
            SinglyNode<Integer> prev = null;
            SinglyNode<Integer> curr = head;
            SinglyNode<Integer> next = curr.next;

            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    if (prev == null) {
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    } else {
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }

    private static int lengthLL(SinglyNode<Integer> head) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }

}
