package com.my.datastrcture.codingninja.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {2, 13, 4, 1, 3, 6, 28};
        int size = arr.length;
        printArray(arr);
        insertionSort(arr, size);
        printArray(arr);
    }

    public static void insertionSort(int[] arr, int size) {

        for (int i = 1; i < size; i++){
            int j = i - 1;
            int temp = arr[i];

            while (j >= 0 && arr[j] > temp ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void printArray(int arr[]){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
