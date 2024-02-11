package com.my.datastrcture.codingninja.recursion;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int arr[] = {1100};
        //int si = 0;
        System.out.println(arraySortedOrNot(arr, arr.length));
    }

    public static boolean arraySortedOrNot(int []A, int N) {
        return arraySortedOrNot(A, N, 0);
    }

    public static boolean arraySortedOrNot(int arr[], int n, int startIndex){
        if (startIndex == n-1){
            return true;
        }

        if (arr[startIndex] > arr[startIndex+1]){
            return false;
        }
        return arraySortedOrNot(arr, n,startIndex+1);
    }
}
