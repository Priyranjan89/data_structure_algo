package com.my.datastrcture.codingninja.priorityqueue;

public class CheckMaxHeap {
    public static void main(String[] args) {
        int arr[] = {42,20,18,6,14,11,9,4};
        System.out.println(checkMaxHeap(arr));
    }

    public static boolean checkMaxHeap(int arr[]) {
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            if((2*i+1)<n && arr[i]<arr[2*i+1])
                return false;
            if((2*i+2)<n && arr[i]<arr[2*i+1])
                return false;
        }
        return true;
    }
}
