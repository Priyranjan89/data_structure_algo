package com.my.datastrcture.codingninja.arrays;

public class SumOfArrayElement {
    public static void main(String[] args) {
        int arr[] = {7,3,8,3,9,6,2,10};
        System.out.println(sumOfArray(arr));
    }
    public static int sumOfArray(int arr[]){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }

        return sum;
    }
}
