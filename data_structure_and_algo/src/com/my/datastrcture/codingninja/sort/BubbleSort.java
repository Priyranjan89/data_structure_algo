package com.my.datastrcture.codingninja.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {2, 13, 4, 1, 3, 6, 28};
        int n = arr.length;
        printArray(arr);
        bubbleSort(arr, n);
        printArray(arr);

    }

    public static void bubbleSort(int[] arr, int n) {
        //outer loop for passes
        for (int i = 0; i < n - 1; i++){
            //inner loop for comparison
            for (int j = 0; j < n -1-i; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int arr[]){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
