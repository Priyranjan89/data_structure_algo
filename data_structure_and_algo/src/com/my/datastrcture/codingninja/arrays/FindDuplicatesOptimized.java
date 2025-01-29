package com.my.datastrcture.codingninja.arrays;

public class FindDuplicatesOptimized {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 6, 3, 7};

        System.out.print("Duplicate elements: ");
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                System.out.print((index + 1) + " ");
            } else {
                arr[index] = -arr[index];
            }
        }
    }
}
