package com.my.datastrcture.codingninja.arrays;

public class SortArraysInZeroAndOne {
    public static void main(String[] args) {
        int arr1[] = {1,1,0,0,1,0};
        sortZeroesAndOne(arr1);
        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }

    public static void sortZeroesAndOne(int[] arr) {
        int placeToMoveZero = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                swap(arr, placeToMoveZero, i);
                placeToMoveZero++;
            }
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
