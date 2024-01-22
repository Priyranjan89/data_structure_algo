package com.my.datastrcture.codingninja.arrays;

public class SumOfTwoArraysIntuition {
    public static void main(String[] args) {
        int a[] = {9, 7, 6, 6, 8, 4};
        int b[] = {55, 5, 7, 18, 34};
        int max = (Math.max(a.length, b.length))+1;
        int sum[] = new int[max];
        sumOfTwoArrays(a, b, sum);
        printArray(a);
        printArray(b);
        printArray(sum);
    }

    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]){
        int i = arr1.length-1;
        int j = arr2.length-1;
        int k = output.length-1;

        int carry = 0;

        while (i >= 0 && j >= 0 ){
            int total = arr1[i]+arr2[j]+carry;
            output[k] = total%10;
            carry = total/10;
            i--;
            j--;
            k--;
        }

        while (i >= 0){
            int total = arr1[i]+carry;
            output[k] = total%10;
            carry = total/10;
            i--;
            k--;
        }

        while (j >= 0){
            int total = arr2[j]+carry;
            output[k] = total%10;
            carry = total/10;
            j--;
            k--;
        }
        if (carry > 0){
            output[k] = carry;
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
