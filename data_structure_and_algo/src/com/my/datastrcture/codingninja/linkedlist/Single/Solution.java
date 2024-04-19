package com.my.datastrcture.codingninja.linkedlist.Single;

public class Solution {
    public static boolean isPalindrome(SinglyNode<Integer> head) {

        SinglyNode<Integer> temp=head,mid,h2;
        mid=midPoint(temp);
        h2=mid.next ;
        mid.next=null;
        h2=reverseIt(h2);
        boolean flag=false;
        while(temp!=null && h2!=null)
        {   flag=false;
            if(temp.data.equals(h2.data))
                flag=true;
            temp=temp.next;
            h2=h2.next;

        }
        return flag;
    }


    private static SinglyNode<Integer> reverseIt(SinglyNode<Integer> head)
    {   if(head==null || head.next==null)
        return head;
        SinglyNode<Integer> tail=head.next;
        SinglyNode<Integer> ans=reverseIt(head.next);
        tail.next=head;
        head.next=null;
        return ans;


    }

    private static SinglyNode<Integer> midPoint(SinglyNode<Integer> head){
        SinglyNode<Integer> slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

}
