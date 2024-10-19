package com.my.datastrcture.codingninja.arrays;

public class ReverseIntuition {
    public static void main(String[] args) {
        int arr[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n = arr.length;
        printArray(arr);
        //reverseArray(arr, n);
        reverseArr(arr, n);
        printArray(arr);

    }
    public static int[] reverseArray(int nums[], int n){
        for (int l = 0, r  = n-1; l < r; l++, r--){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        return nums;
    }
    public static int[] reverseArr(int nums[], int n){
        int l = 0, r  = n-1;
        while ( l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
