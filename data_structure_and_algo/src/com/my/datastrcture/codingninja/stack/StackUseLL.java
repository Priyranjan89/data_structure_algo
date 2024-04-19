package com.my.datastrcture.codingninja.stack;

public class StackUseLL {
    public static void main(String[] args) throws StackEmptyException {
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        int arr[] = {5, 6, 7, 1, 9};
        System.out.println(stack.isEmpty());

        for (int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }
        stack.push(10);
        System.out.println(stack.top());
        //System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println("\n After pop all element");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
