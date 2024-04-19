package com.my.datastrcture.codingninja.stack;

public class StackUsingArray {
    private int data[];
    private int topIndex;  //Index of the top most element of the stack

    public StackUsingArray(){
        data = new int[2];
        topIndex = -1;
    }

    public int size(){
        return topIndex + 1;
    }

    public boolean isEmpty(){
        /*if (topIndex == -1){
            return true;
        }
        return false;*/
        return topIndex == -1;
    }

    public void push(int element){
        //if stack is full then create double capacity stack
        if (topIndex == data.length-1){
            doubleCapacity();
        }
        topIndex++;
        data[topIndex] = element;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int top()throws StackEmptyException{
        if (topIndex == -1){
            throw new StackEmptyException("Stack is Epmty");
        }
        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if (topIndex == -1){
            throw new StackEmptyException("Stack is Epmty");
        }

        int temp = data[topIndex];
        data[topIndex--] = 0;

        return temp;
    }

}
