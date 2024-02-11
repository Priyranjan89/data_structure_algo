package com.my.datastrcture.codingninja.sort;

public class SecondLargestInArray {

    public static void main(String[] args) {
        //int arr[] = {13, 6, 31, 14, 29, 44, 3};
        int arr[] = {4, 3, 10, 9, 2};
        int n = 5;
        System.out.println(secondLargestElement(arr, n));
    }

    public static int secondLargestElement(int[] arr, int n) {
        int firstLargest = arr[0];
        int secondLargest = arr[0];

        for (int i = 1; i < n; i++){

            if (arr[i] > firstLargest){
                secondLargest = firstLargest;
                firstLargest = arr[i];

            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}
