package com.my.datastrcture.codingninja.arrays;

public class SortZerosOneAndTwoInArray {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 2, 0, 1};
        printArray(arr);
        sort012(arr);
        printArray(arr);
    }

    public static void sort012(int[] arr){
        int placeToMoveZero = 0;
        int high = arr.length-1;
        int i = 0;

        while (i < arr.length && i <= high){
            if (arr[i] == 0){
                swap(arr, placeToMoveZero, i);
                placeToMoveZero++;
                i++;
            } else  if (arr[i] == 2){
                swap(arr, high, i);
                high--;
            } else {
                i++;
            }
        }
        /*for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                swap(arr, placeToMoveZero, i);
                placeToMoveZero++;
            }
        }

        int placeToMoveOne = placeToMoveZero;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                swap(arr, placeToMoveOne, i);
                placeToMoveOne++;
            }
        }*/
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }



}
