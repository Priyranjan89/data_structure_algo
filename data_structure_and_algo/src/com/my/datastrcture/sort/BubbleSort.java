package com.my.datastrcture.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {6, 2, 8, 4, 10};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.print("[ ");
        for (int i =0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }

    public static void bubbleSort(int[] arr, int n) {
        for (int i = 1; i < n; i++){
            boolean swapped = false;
            //for round 1 to n-1
            for (int j = 0; j < n-i; j++){
                //process the element till n-1
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
