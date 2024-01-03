package com.my.datastrcture.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {6, 2, 8, 4, 10};
        int n = arr.length;
       selectionSort(arr, n);
        System.out.print("[ ");
       for (int i =0; i < n; i++)
       {
           System.out.print(arr[i]+" ");
       }
        System.out.print("]");
    }

    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int arr[], int i, int index){
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
