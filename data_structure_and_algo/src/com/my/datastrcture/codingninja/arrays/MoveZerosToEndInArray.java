package com.my.datastrcture.codingninja.arrays;

public class MoveZerosToEndInArray {
    public static void main(String[] args) {
        int arr[] = {8, 0, 4, 0, 0, 3, 2, 0, 1, 0};
        printArray(arr);
        moveZerosToEnd(arr, arr.length);
        printArray(arr);
    }

    public static void moveZerosToEnd(int a[], int n){
        int nonZero = 0;
        for (int zero = 0; zero < n; zero++){
            if (a[zero] != 0){
                swap(a, zero, nonZero);
                nonZero++;
            }
        }

    }

    public static void swap(int arr[], int zero, int nonZero){
        int temp = arr[zero];
        arr[zero] = arr[nonZero];
        arr[nonZero] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
