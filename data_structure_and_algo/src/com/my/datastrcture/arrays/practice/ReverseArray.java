package com.my.datastrcture.arrays.practice;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 4, 9, 8, 6};

        printArray(arr);
        reverseArr(arr);
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        System.out.print(" Value of array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverseArr(int arr[]) {
        int temp = 0;

        for (int start = 0, end = arr.length - 1; start <= end; end--, start++) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        return arr;
    }
}
