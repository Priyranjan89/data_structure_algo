package com.my.datastrcture.codestudio;

public class Sort01 {
    public static void main(String[] args) {
        int arr[] = {1, 0 , 0, 1, 1, 0, 1, 0, 0 ,1};
        sort01(arr);
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
    public static void sort01(int[] arr) {
        int left = 0;
        int n = arr.length;
        int right = n-1;

        while (left < right){
            while (arr[left] == 0 && left < right){
                left++;
            }
            while (arr[right] == 1 && left < right){
                right--;
            }
            if (left < right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }
}
