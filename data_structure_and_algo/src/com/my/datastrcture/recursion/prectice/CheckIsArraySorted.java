package com.my.datastrcture.recursion.prectice;

public class CheckIsArraySorted {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 10, 12, 15};
        System.out.println(isArraySorted(arr, 0));
    }

    public static boolean isArraySorted(int []arr, int index) {
        if (index == arr.length-1){
            return true;
        }

        if (arr[index] > arr[index+1]){
            return false;
        }

        return isArraySorted(arr, index+1);
    }
}
