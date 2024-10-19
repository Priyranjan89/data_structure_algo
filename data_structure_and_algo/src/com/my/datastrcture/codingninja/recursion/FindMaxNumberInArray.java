package com.my.datastrcture.codingninja.recursion;

import static java.lang.Math.max;

public class FindMaxNumberInArray {
    public static void main(String[] args) {
        int arr[] = {10, 30, 20, 40, 50, 25, 45};
        int max = Integer.MIN_VALUE;
        System.out.println(maxValue(arr, max, 0));
    }

    private static int maxValue(int arr[], int max, int index){
        if (arr.length == index){
            return max;
        }
        max = max(max, arr[index]);
        /*if (arr[index] > max){
            max = arr[index];
        }*/
        return maxValue(arr, max, index+1);
    }
}
