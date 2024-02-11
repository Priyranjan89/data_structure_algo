package com.my.datastrcture.codingninja.arrays;

public class FindLeadersInArray {
    public static void main(String[] args) {
      //  int arr[] = {3, 12, 34, 2, 0, -1};
        int arr[] = {13, 17, 5, 4, 6};
        printArray(arr);
        leaders(arr);
    }

    public static void leaders(int[] input) {
        int temp = Integer.MIN_VALUE;

        for (int i = input.length-1; i >= 0; i--) {
            if (input[i] >= temp) {
                temp = input[i];
                System.out.print(temp+" ");
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
