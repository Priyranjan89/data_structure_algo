package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class UpdatingTheArray {
    public static void main(String[] args) {
        int arr[] = {24, 4, 7, 73, 56, 14, 52, 7};

        printArray(arr);
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the key : ");
        int key = sc.nextInt();
        System.out.print("Please enter the value to replace key : ");
        int value = sc.nextInt();
        update(arr, key, value);
        printArray(arr);
    }

    public static void update(int[] arr, int key, int value){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == key){
                arr[i] = value;
                return;
            }
            System.out.println("Key not found in Array");
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
