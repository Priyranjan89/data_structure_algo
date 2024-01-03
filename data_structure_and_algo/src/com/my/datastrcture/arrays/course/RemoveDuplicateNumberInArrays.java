package com.my.datastrcture.arrays.course;

public class RemoveDuplicateNumberInArrays {

    public static int removeDuplicate(int a[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }
        a[j++] = a[n - 1];
        return j;
    }

    public static int[] removeDuplicates(int[] arr) {
        int result = removeDuplicate(arr, arr.length);
        int newArr[] = new int[result];

        for (int i = 0; i < result; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 4, 5};
        int result[] = removeDuplicates(arr);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print("]");
    }
}
