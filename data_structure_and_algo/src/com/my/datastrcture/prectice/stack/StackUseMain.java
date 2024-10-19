package com.my.datastrcture.prectice.stack;

import com.my.datastrcture.codingninja.stack.StackEmptyException;
import com.my.datastrcture.codingninja.stack.StackFullException;

public class StackUseMain {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        //StackWithArray stack = new StackWithArray(10);
        StackWithLinkedList<Integer> stack = new StackWithLinkedList();
        System.out.println(stack.isEmpty());

        int arr[] = {9 ,1 , 3, 8, 4, 5};
        for (int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(stack.pop());
        }

       /* stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.top());*/
        
    }
}
