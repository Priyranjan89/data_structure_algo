package com.my.datastrcture.codingninja.Test2;

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node<Integer> head) {
        while(head.next!=null){
            if(head.next.next!=null){
                head.next=head.next.next;
                head=head.next;
            }else{
                head.next=null;
            }
        }
    }
}
