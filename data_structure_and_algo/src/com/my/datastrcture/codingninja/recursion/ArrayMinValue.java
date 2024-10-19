package com.my.datastrcture.codingninja.recursion;

public class ArrayMinValue {
    public static void main(String[] args) {
        int arr[] = {34, 20, 45, 7, 98, 36, 9};
        printMinValue(arr, 0, Integer.MAX_VALUE);
    }
    private static void printMinValue(int arr[], int index, int min){
        if (arr.length == index){
            System.out.println(min);
            return;
        }
        min = Math.min(min, arr[index]);
        printMinValue(arr, index+1, min);
    }
}
