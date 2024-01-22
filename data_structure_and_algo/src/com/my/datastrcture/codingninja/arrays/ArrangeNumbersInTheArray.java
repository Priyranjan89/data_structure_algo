package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class ArrangeNumbersInTheArray {
    public static void main(String[] args) {
        int n = 9;
        int arr[] = new int[n];
        arrange(arr, n);
        printArray(arr);
    }

    public static void arrange(int[] arr, int n) {
        int num = 1;
        int l = 0;
        int r = n-1;

        while (l <= r){
            if (num%2 != 0){
                arr[l] = num;
                num++;
                l++;
            } else {
                arr[r] = num;
                num++;
                r--;
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
