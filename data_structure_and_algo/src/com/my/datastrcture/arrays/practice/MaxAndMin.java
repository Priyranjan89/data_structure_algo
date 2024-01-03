package com.my.datastrcture.arrays.practice;

import java.util.Scanner;

public class MaxAndMin {
    public static void main(String[] args) {

        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Array");
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        printMaxAndMinValue(arr);
    }

    private static void printMaxAndMinValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.print("Value of Array : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");

        for (int i = 0; i < arr.length; i++){
            /*max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);*/
            if (arr[i] > max){
                max = arr[i];
            } else if (arr[i] < min){
                min =  arr[i];
            }
        }

        System.out.println("Max value in Array: "+max);
        System.out.println("Min value in Array: "+min);
    }
}
