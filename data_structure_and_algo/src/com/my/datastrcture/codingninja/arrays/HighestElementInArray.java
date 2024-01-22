package com.my.datastrcture.codingninja.arrays;

public class HighestElementInArray {
    public static void main(String[] args) {
        int arr[] = {8, 34, 46, 25, 89, 55, 3};
        System.out.println(highestValue(arr));

    }
    public static int highestValue(int arr[]){
        int highest = Integer.MIN_VALUE;

        for(int i : arr){
            if (i > highest ){
                highest = i;
            }
        }
        return highest;
    }
}
