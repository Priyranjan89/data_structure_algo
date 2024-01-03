package com.my.datastrcture.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {10, 1, 7, 4, 8, 2, 11};
        int n = arr.length;
        insertionSort(n, arr);
        System.out.print("[ ");
        for (int i =0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }

    // Method of Insertion Sort
    public static void insertionSort(int n , int[] arr) {
        // Outer Loop for Number of Passes
       for (int i = 1; i < n; i++){
           int temp = arr[i];
           int j = i -1;
           // Inner Loop for Comparison
           while (j >= 0){
               if (arr[j] > temp){
                   //shift
                   arr[j+1] = arr[j];
               } else{//stop
                   break;
               }
               j--;
           }
           //copy temp value
           arr[j+1] = temp;
       }
    }
}
