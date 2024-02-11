package com.my.datastrcture.codingninja.sort;

public class MargeSort2 {
    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 6, 2, 5, 7};
        int size= arr.length;

        System.out.println("Before Sorting");

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr , size);
        System.out.println("After Sorting");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n-1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        marge(arr, start, end);
    }

    private static void marge(int arr[], int start, int end){
        int mid = (start+end)/2;
        int len1 = mid-start+1;
        int len2 = end-mid;

        int arr1[] = new int[len1];
        int arr2[] = new int[len2];

        int originalArrayIndex = start;

        for (int i = 0; i < len1; i++){
            arr1[i] = arr[originalArrayIndex++];
        }

        for (int i = 0; i < len2; i++){
            arr2[i] = arr[originalArrayIndex++];
        }

        originalArrayIndex = start;
        int i = 0, j = 0;

        while (i < len1 && j < len2){
            if (arr1[i] < arr2[j]){
                arr[originalArrayIndex++] = arr1[i++];
            } else {
                arr[originalArrayIndex++] = arr2[j++];
            }
        }

        while (i < len1){
            arr[originalArrayIndex++] = arr1[i++];
        }

        while (j < len2){
            arr[originalArrayIndex++] = arr2[j++];
        }
    }
}
