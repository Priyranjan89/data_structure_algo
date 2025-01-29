package com.my.datastrcture.prectice.leetcode.medium;

public class SortColors75 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 2, 0, 1};
        printArray(arr);
        sortColors(arr);
        printArray(arr);
    }
    public static void sortColors(int[] nums) {
        int placeToMoveZero = 0;
        int high = nums.length-1;
        int i = 0;

        while (i < nums.length && i <= high){
            if (nums[i] == 0){
                swap(nums, placeToMoveZero, i);
                placeToMoveZero++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, high, i);
                high--;
            } else {
                i++;
            }
        }
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
