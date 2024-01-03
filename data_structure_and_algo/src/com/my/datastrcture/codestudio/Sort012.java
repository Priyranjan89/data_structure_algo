package com.my.datastrcture.codestudio;

public class Sort012 {

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 1, 2, 1, 2, 0, 0, 1, 2, 1};
        sort012(arr);
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;

            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }

    }
}
