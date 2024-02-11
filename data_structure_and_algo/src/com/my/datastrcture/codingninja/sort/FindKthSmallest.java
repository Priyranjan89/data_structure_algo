package com.my.datastrcture.codingninja.sort;

public class FindKthSmallest {
    public static void main(String[] args) {
        //int arr[] = {17, 5, 14, 16, 11, 18, 10};
        int arr[] = {3, 2, 5, 11, 1};
        int k = 2;
        int n = arr.length;
        printArray(arr);
        int ans = kthSmallest(arr, n, k);
        printArray(arr);
        System.out.println(ans);
    }

    public static int kthSmallest(int[] arr, int n, int k){
        int ans = 0;

        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-1-i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        if (n > k){
            ans = arr[k-1];
            return ans;
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
