package com.my.datastrcture.linkedList.example;

import java.util.HashSet;

public class RemoveDuplicate {

    public void deleteDuplicate(LinkedList ll){
        HashSet<Integer>  hs = new HashSet<>();
        Node current = ll.head;
        Node pre = null;

        while (current != null){
            int val = current.value;
            if (hs.add(val) == false){
                pre.next = current.next;
                ll.size--;
            } else {
                pre = current;
            }
            current = current.next;
        }
    }
}
