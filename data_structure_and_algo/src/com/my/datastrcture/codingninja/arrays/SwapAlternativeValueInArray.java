package com.my.datastrcture.codingninja.arrays;

public class SwapAlternativeValueInArray {
    public static void main(String[] args) {
        int arr[] = {8, 34, 46, 25, 89, 55, 73, 3, 77};
        swapAlternate(arr);
        for (int i : arr){
            System.out.print(i +" ");
        }
    }

    public static void swapAlternate(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i=i+2){
            if ((i+1) < n){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}
