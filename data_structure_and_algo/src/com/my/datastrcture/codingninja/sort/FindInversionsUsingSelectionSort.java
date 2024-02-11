package com.my.datastrcture.codingninja.sort;

public class FindInversionsUsingSelectionSort {
    public static void main(String[] args) {

        //int arr[] = {3, 2, 11, 5, 1};
        int arr[] = {17, 5, 14, 16, 11, 18, 10};
        int n = arr.length;
        printArray(arr);
        int ans = getInversions(arr, n);
        printArray(arr);
        System.out.println(ans);

    }

    public static int getInversions(int[] arr, int n){
        int ans = 0;

        for (int i = 0; i < n-1; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            ans = ans + (min-i);
        }

        return ans;
    }

    public static void printArray(int arr[]){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
