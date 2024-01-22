package com.my.datastrcture.codingninja.arrays;

public class ReverseArrayBetweenTwoIndex {
    public static void main(String[] args) {
        int arr[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n = arr.length;
        int l = 2;
        int r = 7;
        printArray(arr);
        reverseArray(arr, n, l, r);
        printArray(arr);

    }
    public static int[] reverseArray(int arr[], int n, int l, int r){
        while (l < r)
        {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
