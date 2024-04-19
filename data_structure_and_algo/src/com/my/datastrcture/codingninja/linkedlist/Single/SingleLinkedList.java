package com.my.datastrcture.codingninja.linkedlist.Single;

public class SingleLinkedList<T> {
    public SinglyNode<T> head;
    public SinglyNode<T> tail;
    public int size;

    public SinglyNode<T> createNode(T value){
        SinglyNode<T> singlyNode = new SinglyNode<>(value);
        head = singlyNode;
        tail = singlyNode;
        size = 1;
        return head;
    }

    public SinglyNode<T> insertNode(T value){
        if (head == null){
            return createNode(value);
        } else {
            SinglyNode<T> singlyNode = new SinglyNode<>(value);
            tail.next = singlyNode;
            tail = singlyNode;
        }
        size++;
        return head;
    }
    public static SinglyNode<Integer> insert(SinglyNode<Integer> head, int pos, int data){
        SinglyNode<Integer> singlyNode = new SinglyNode<>(data);
        SinglyNode<Integer> temp = head;
        int idx = 0;

        if(head == null || pos < 0){
            return head;
        }
        if (pos == 0){
            singlyNode.next = head;
            head = singlyNode;
        } else {
            while (idx < pos-1 && temp != null){
                idx++;
                temp = temp.next;
            }
            if (temp != null){
                singlyNode.next = temp.next;
                temp.next = singlyNode;
            }
        }
        return head;
    }

    public SinglyNode<T> deleteNode(SinglyNode<T> head, int pos) {
        SinglyNode<T> temp = head;
        int idx = 0;

        if(head == null || pos < 0){
            return head;
        }
        if (pos == 0){
            head = head.next;
        } else {
            while (idx < pos-1 && temp != null){
                idx++;
                temp = temp.next;
            }
            if (temp != null){
                if (temp.next != null){
                   temp.next = temp.next.next;
                }
            }
        }
        return head;
    }

//Linked-List 1
    public void printLinkedList(SinglyNode<Integer> head){
        SinglyNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    public void printLinkedList(){
        SinglyNode<T> temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void printIthNode(SinglyNode<Integer> head, int i){
        if(head == null || i < 0){
            return;
        }
        int idx = 0;

        SinglyNode<Integer> temp = head;
        while (temp != null){
            if (idx == i){
                System.out.println(temp.data);
            }
            temp = temp.next;
            idx++;
        }
    }

    public static int findNode(SinglyNode<Integer> head, int n) {
        if(head == null || n < 0){
            return -1;
        }
        int idx = 0;

        SinglyNode<Integer> temp = head;
        while (temp != null){
            if (temp.data == n){
               return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    public static SinglyNode<Integer> appendLastNToFirst(SinglyNode<Integer> head, int n) {
        if(head == null || n <= 0){
            return head;
        }
        SinglyNode<Integer> fast = head;
        SinglyNode<Integer> slow = head;
        SinglyNode<Integer> prevHead = head;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        SinglyNode<Integer> newHead = slow.next;
        slow.next = null;
        fast.next = prevHead;
        head = newHead;

        return head;
    }

    public static SinglyNode<Integer> removeDuplicates(SinglyNode<Integer> head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        SinglyNode<Integer> t1 = head, t2 = head.next;
        SinglyNode<Integer> finalhead = head;
        while (t2 != null) {
            if (t1.data.equals(t2.data)) {
                t2 = t2.next;
            } else {
                t1.next = t2;
                t1 = t2;
            }
        }

        t1.next = null;
        return finalhead;
    }

    public static void printReverse(SinglyNode<Integer> root) {
       /* if (root == null){
            return;
        }
        printReverse(root.next);
        System.out.print(root.data+" ");*/
        SinglyNode<Integer> head = reverse_I(root);
        SinglyNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }
    public static SinglyNode<Integer> reverse_I(SinglyNode<Integer> head)
    {
        SinglyNode<Integer> prev=null,curr=head, temp;
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static boolean isPalindrome(SinglyNode<Integer> head) {
        if (head == null || head.next == null){
            return false;
        }

        SinglyNode<Integer> mid = getMidList(head);
        SinglyNode<Integer> revHead = reverseList(mid);

        while (revHead != null && head != null){
            if (revHead.data != head.data){
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }

        return true;
    }

    public static SinglyNode<Integer> getMidList(SinglyNode<Integer> head){
        SinglyNode<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static SinglyNode<Integer> findMiddle(SinglyNode<Integer> head)
    {
        if(head == null || head.next == null){
            return head;
        }
        SinglyNode<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static SinglyNode<Integer> reverseList(SinglyNode<Integer> currentSinglyNode){
        SinglyNode<Integer> prev = null, next = null;
        while (currentSinglyNode != null){
            next = currentSinglyNode.next;
            currentSinglyNode.next = prev;
            prev = currentSinglyNode;
            currentSinglyNode = next;
        }
        return prev;
    }


   /* public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if(head == null ){
            return null;
        }

        Node<Integer> temp = head;

        while (temp.next != null){
            if (temp.data == temp.next.data){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }*/
}
