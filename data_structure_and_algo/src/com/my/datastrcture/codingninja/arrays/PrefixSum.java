package com.my.datastrcture.codingninja.arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        //int arr[] = {4, 8, 9, 11};
        printArray(arr);
        //prefixSum(arr);
        prefixSumOptimized(arr);
        printArray(arr);

    }
    public static void prefixSum(int[] arr) {
        int n = arr.length;
        int p[] = new int[n];

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j <= i; j++){
                sum += arr[j];
            }
            p[i] = sum;
        }

        for (int i = 0; i < n; i++){
            arr[i] = p[i];
        }
    }

    public static void prefixSumOptimized(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++){
            sum += arr[i];
            arr[i] = sum;
        }

        /*for (int i = 0; i < n; i++){
            arr[i] = p[i];
        }*/
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
