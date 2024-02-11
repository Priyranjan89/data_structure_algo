package com.my.datastrcture.codingninja.oops;

public class DynamicArray {

    private int nextElementIndex;
    private int arr[];

    public DynamicArray(){
        arr = createArray(0);
    }

    public int size(){
        return nextElementIndex;
    }

    public int get(int index){
        if (index < nextElementIndex && index >= 0){
            return arr[index];
        }
        return 0;
    }

    public void add(int element){
        if (nextElementIndex == arr.length){
            doubleCapacity();
        }
        arr[nextElementIndex] = element;
        nextElementIndex++;
    }

    public void set(int element, int index){
        if (index >= nextElementIndex){
            return;
        }
        arr[index] = element;
    }

    public void printArray(){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int remove(){
        if (nextElementIndex == 0){
            return -1;
        }
        int temp = arr[nextElementIndex-1];
        arr[nextElementIndex-1] = 0;
        nextElementIndex--;
        return temp;
    }

    public boolean isEmpty(){
        if (nextElementIndex == 0){
            return true;
        }
        return false;
    }

    private void doubleCapacity() {
        int temp[] = createArray(2 * nextElementIndex);
        for (int i = 0, j =0; i < temp.length && j < arr.length; i++,j++){
            temp[i] = arr[j];
        }
        arr = temp;
    }

    private int[] createArray(int len){
        int temp[];
        if (len <= 0){
            temp = new int[2];
        } else {
            temp = new int[len];
        }
        return temp;
    }
}
