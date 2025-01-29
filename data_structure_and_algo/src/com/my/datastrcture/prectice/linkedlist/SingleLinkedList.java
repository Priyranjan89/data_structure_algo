package com.my.datastrcture.prectice.linkedlist;


public class SingleLinkedList<T> {
    public SinglyNode<T> head;
    public SinglyNode<T> tail;
    public int size;

    public SinglyNode<T> createNode(T value){
        head = new SinglyNode<T>(value);
        tail = head;
        size = 1;
        return head;
    }

    public SinglyNode<T> insertNewNode(T value){
        if (head == null){
            return createNode(value);
        } else {
            SinglyNode<T> node = new SinglyNode<>(value);
            tail.next = node;
            tail = node;
            size++;
            return head;
        }
    }

    public SinglyNode<T> insertNewNodeWithHead(SinglyNode<T> head, T value){
        if (head == null){
           return new SinglyNode<>(value);
        } else {
            SinglyNode<T> node = new SinglyNode<>(value);

            SinglyNode<T> temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;

            return head;
        }
    }

    public Pair<T> insertNewNodeWithHeadAndTail(Pair<T> pair, T value){
        if (pair == null){
            Pair<T> newPair = new Pair<>();
            SinglyNode<T>  node = new SinglyNode<>(value);
            newPair.head = node;
            newPair.tail = node;
            return newPair;

        } else {
            SinglyNode<T> node = new SinglyNode<>(value);
            SinglyNode<T> tail = pair.tail;
            tail.next = node;
            pair.tail = node;

            return pair;
        }
    }

    public SinglyNode<T> insertNewNodeAtPosition(SinglyNode<T> head, T data, int pos){
        if (head == null || pos < 0){
            return head;
        }
        SinglyNode<T> currentNode = new SinglyNode<>(data);
        if (pos == 0){
            currentNode.next = head;
            return currentNode;
        } else {
            SinglyNode<T> temp = head;
            int idx = 0;
            while (temp != null && idx < pos){
                if (idx == pos-1){
                    currentNode.next = temp.next;
                    temp.next = currentNode;
                }
                temp = temp.next;
                idx++;
            }
            return head;
        }
    }

    public SinglyNode<T> insertNodeAtPositionRecursively(SinglyNode<T> head, T data, int pos){
        if (head == null && pos > 0){
            return head;
        }
        SinglyNode<T> newNode = new SinglyNode<>(data);
        if (pos == 0){
            newNode.next = head;
            return newNode;
        } else {
            //return insertNodeHelper(head, newNode, pos, 0);
            head.next = insertNodeAtPositionRecursively(head.next, data, pos-1);
            return head;
        }
    }

    public SinglyNode<T> insertNodeHelper(SinglyNode<T> head, SinglyNode<T> newNode, int pos, int index){
        if (head == null){
            return head;
        }
        if (index == pos-1){
            newNode.next = head.next;
            head.next = newNode;
            return head;
        }

        SinglyNode<T> smallAns =  insertNodeHelper(head.next, newNode, pos, index+1);
        head.next = smallAns;

        return head;
    }

    public SinglyNode<T> deleteNode( SinglyNode<T> head, int pos) {
        if (head == null || pos < 0){
            return head;
        }
        if (pos == 0){
            head = head.next;
        } else {
            SinglyNode<T> temp = head;
            int idx = 0;
            while (temp != null && idx < pos){
                if (idx == pos-1 && temp.next != null){
                    temp.next = temp.next.next;
                }
                temp = temp.next;
                idx++;
            }
        }
        return head;
    }

    public SinglyNode<T> deleteNodeRecursively( SinglyNode<T> head, int pos) {
        if (head.next == null && pos > 0){
            return head;
        }

        if (pos == 0){
            return head.next;
        } else {
            head.next = deleteNodeRecursively(head.next, pos-1);
            return head;
        }
    }
     public SinglyNode<T> deleteNodeWithPos( SinglyNode<T> head, int pos) {
        if (head == null || pos < 0){
            return head;
        }
        if (pos == 0){
            head = head.next;
        } else {
            SinglyNode<T> temp = head;
            int idx = 0;
            while (temp != null && idx < pos-1){
                temp = temp.next;
                idx++;
            }
            if (temp != null && temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    public SinglyNode<T> deleteNodeWithData( SinglyNode<T> head, T data) {
        if (head == null){
            return head;
        }
        if (head.data == data){
            head = head.next;
        }else {
            SinglyNode<T> temp = head;
            SinglyNode<T> prev = null;
            while (temp != null ){
                if (temp.data == data){
                    break;
                }
                prev = temp;
                temp = temp.next;

            }
            if (prev.next != null){
                prev.next = prev.next.next;
            }
        }
        return head;
    }

    public int findNode( SinglyNode<T> head, T data) {
        if (head == null)
            return -1;

        int idx = 0;
        SinglyNode<T> temp = head;
        while (temp != null){
            if (temp.data == data){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    //appendLastNToFirst
    public SinglyNode<T> appendLastNToFirst(SinglyNode<T> head, int n){
        if (head == null || n <= 0){
            return head;
        }
        SinglyNode<T> temp = head;
        SinglyNode<T> prev = head;
        SinglyNode<T> tail = head;
        int len = 0;
        while (temp != null){
            len++;
            tail = temp;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < (len-n); i++){
            prev = temp;
            temp = temp.next;
        }
        SinglyNode<T> newHead = temp;
        prev.next = null;
        tail.next = head;

        return newHead;
    }

    public SinglyNode<T> appendLastNToFirstBetter(SinglyNode<T> head, int n) {
        if(head == null || n <= 0){
            return head;
        }
        SinglyNode<T> fast = head;
        SinglyNode<T> slow = head;
        SinglyNode<T> prevHead = head;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        SinglyNode<T> newHead = slow.next;
        slow.next = null;
        fast.next = prevHead;
        head = newHead;

        return head;
    }

    public SinglyNode<T> removeDuplicates(SinglyNode<T> head){
        if (head == null || head.next == null){
            return head;
        }

        SinglyNode<T> t1 = head, t2 = head.next;
        SinglyNode<T> finalHead = head;

        while (t2 != null){
            if (t1.data.equals(t2.data)){
                t2 = t2.next;
            } else {
                t1.next = t2;
                t1 = t2;
            }
        }
        return finalHead;
    }

    public void printReverse(SinglyNode<T> root){
        if (root == null){
            return;
        }
        printReverse(root.next);
        System.out.print(root.data+" ");
    }

    public boolean isPalindrome(SinglyNode<T> head) {
        if (head == null || head.next == null){
            return false;
        }

        SinglyNode<T> mid = getMid(head);
        SinglyNode<T> revHead = reverseLL(mid);

        while (revHead != null && head != null){
            if (revHead.data != head.data){
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }

    private SinglyNode<T> tails = null;
    public SinglyNode<T> reverseLLUsingRecursion(SinglyNode<T> root){
        if (root.next == null){
            tails = root;
            return root;
        }

        SinglyNode<T> head = reverseLLUsingRecursion(root.next);
        root.next = null;
        tails.next = root;
        tails = root;

        return head;
    }
    public SinglyNode<T> reverseLLRecursionBest(SinglyNode<T> root){
        if (root.next == null){
            return root;
        }

        SinglyNode<T> head = reverseLLUsingRecursion(root.next);
        SinglyNode<T> tailNext = root.next;
        tailNext.next = root;
        root.next = null;

        return head;
    }


    public SinglyNode<T> reverseLL(SinglyNode<T> currentNode){
        SinglyNode<T> prev = null, next = null;
        while (currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    public SinglyNode<Integer> mergeSort(SinglyNode<Integer> head){
        if (head == null || head.next == null){
            return head;
        }

        //Type cast below line
        SinglyNode<Integer> mid = (SinglyNode<Integer>) getMid((SinglyNode<T>) head);
        SinglyNode<Integer> part1 = head;
        SinglyNode<Integer> part2 = mid.next;
        mid.next = null;

        SinglyNode<Integer> head1 = mergeSort(part1);
        SinglyNode<Integer> head2 = mergeSort(part2);

        return margeTwoSortedList(head1, head2);
    }

    public SinglyNode<T> getMid(SinglyNode<T> head){

        if(head == null || head.next == null){
            return head;
        }
        SinglyNode<T> slow = head;
        SinglyNode<T> fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public SinglyNode<Integer> margeTwoSortedList(SinglyNode<Integer> head1, SinglyNode<Integer>head2){
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
        SinglyNode<Integer> finalHead = null, tails = null;

        if (temp1.data <= temp2.data){
            finalHead = temp1;
            tails = temp1;
            temp1 = temp1.next;
        } else {
            finalHead = temp2;
            tails = temp2;
            temp2 = temp2.next;
        }

        while (temp1 != null && temp2 != null){
            if (temp1.data <= temp2.data){
                tails.next = temp1;
                tails = temp1;
                temp1 = temp1.next;
            } else {
                tails.next = temp2;
                tails = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null){
            tails.next = temp1;
        } else {
            tails.next = temp2;
        }

        return finalHead;
    }

    public static int findNodeRec(SinglyNode<Integer> head, int n) {
        return findNodeRecHelper(head, n, 0);
    }
    public static int findNodeRecHelper(SinglyNode<Integer> head, int n, int index) {
        if (head == null){
            return -1;
        }

        if (head.data == n){
            return index;
        }

        return findNodeRecHelper(head.next, n, index+1);
    }

    public SinglyNode<Integer> evenAfterOdd(SinglyNode<Integer> head) {
        if (head == null ){
            return head;
        }
        SinglyNode<Integer> oddHead = null, oddTail = null, evenHead = null, evenTail = null;

        while (head != null){
            if (head.data %2 == 0){
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

    public SinglyNode<Integer> skipMDeleteN(SinglyNode<Integer> head, int M, int N) {
        if (head == null){
            return head;
        }
        if (M <= 0 ){
            return null;
        }
        if (N <= 0){
            return head;
        }
        SinglyNode<Integer> currentNode = head, temp = null;

        while (currentNode != null){
            int take = 0;
            int skip = 0;

            while (currentNode != null && take < M){
                if (temp == null){
                    temp = currentNode;
                } else {
                    temp.next = currentNode;
                    temp = currentNode;
                }
                currentNode = currentNode.next;
                take++;
            }

            while (currentNode != null && skip < N){
                currentNode = currentNode.next;
                skip++;
            }
        }
        if (temp != null){
            temp.next = null;
        }

        return head;
    }

    public SinglyNode<Integer> swapNodes(SinglyNode<Integer> head, int i, int j) {
        if (head == null){
            return head;
        }

        SinglyNode<Integer> temp = head, prev = null, curr1 = null, prev1 = null, curr2 = null, prev2  = null;
        int pos = 0;

        while (temp != null){
            if (pos == i){
                prev1 = prev;
                curr1 = temp;
            }
            if (pos == j){
                prev2 = prev;
                curr2 = temp;
            }
            prev = temp;
            temp = temp.next;
            pos++;
        }

        if (prev1 != null){
            prev1.next = curr2;
        } else {
            head = curr2;
        }

        if (prev2 != null){
            prev2.next = curr1;
        } else {
            head = curr1;
        }

        SinglyNode<Integer> temp1 = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp1;

        return head;
    }

    public SinglyNode<Integer> kReverse(SinglyNode<Integer> head, int k) {
        if (k == 0 || k == 1){
            return head;
        }
        SinglyNode<Integer> currentNode = head;
        SinglyNode<Integer> next = null;
        SinglyNode<Integer> prev = null;

        int count = 1;

        while (count <= k && currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            count++;
        }
        if (next != null){
            head.next = kReverse(next, k);
        }
        return prev;
    }

    public SinglyNode<Integer> kReverseSecond(SinglyNode<Integer> head, int k) {
        if (k == 0 || k == 1){
            return head;
        }
        int index = 0;
        SinglyNode<Integer> temp = head;
        while (temp != null && index < k){
            temp = temp.next;
            index++;
        }
        if (index != k){
            return head;
        }

        SinglyNode<Integer> currentNode = head;
        SinglyNode<Integer> next = null;
        SinglyNode<Integer> prev = null;

        int count = 1;

        while (count <= k && currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            count++;
        }
        if (next != null){
            head.next = kReverseSecond(next, k);
        }
        return prev;
    }

    public int length(SinglyNode<T> head){
        int size = 0;
        if (head == null){
            return size;
        }

        SinglyNode<T> temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void printLL(SinglyNode<T> head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public void printIthNode(SinglyNode<T> head, int i){
        if (head == null || i < 0){
            return;
        }
        int idx = 0;
        while (head != null){
            if (idx == i){
                System.out.println(head.data);
                break;
            }
            head = head.next;
            idx++;
        }
    }
}
