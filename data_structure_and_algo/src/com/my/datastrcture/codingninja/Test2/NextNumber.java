package com.my.datastrcture.codingninja.Test2;



public class NextNumber {
    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode<>(9);
        LinkedListNode node1 = new LinkedListNode<>(9);
        LinkedListNode node2 = new LinkedListNode<>(9);
        //LinkedListNode node3 = new LinkedListNode<>(5);
        head.next = node1;
        node1.next = node2;
        //node2.next = node3;
        printLinkedList(head);
        LinkedListNode<Integer> result = nextLargeNumber(head);
        printLinkedList(result);

    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp;
        LinkedListNode<Integer> prev =null;
        LinkedListNode<Integer> curr=head;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        LinkedListNode<Integer> tem=prev;
        int extra=0;
        LinkedListNode<Integer> a= new LinkedListNode<Integer>(1);
        while(tem!=null){
            if(tem.data==9){
                tem.data=0;
                extra=1;
                if(tem.next==null){
                    tem.next=a;
                }
            }else{
                if(extra==1){
                    int d=tem.data+1;
                    if(d==10){
                        tem.data=0;
                        extra=1;
                    }else{
                        extra=0;
                    }
                }else{
                    tem.data=tem.data+1;
                    break;
                }}
            tem=tem.next;
        }
        LinkedListNode<Integer> temp1;
        LinkedListNode<Integer> prev1 =null;
        LinkedListNode<Integer> curr1=prev;
        while(curr1!=null){
            temp1=curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=temp1;
        }
        return prev1;
    }

    private static void printLinkedList(LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
