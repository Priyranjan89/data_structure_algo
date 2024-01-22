package com.my.datastrcture.codingninja.arrays;

public class SecondLargestNumberInArray {
    public static void main(String[] args) {
        int arr[] = {8, 34, 46, 25, 89, 55, 73, 3};
        System.out.println("Second Largest number in Array : "+secondLargestValue(arr));
    }

    public static int secondLargestValue(int arr[]){
        int max1 = arr[0];
        int max2 = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
        }

        return max2;
    }
}
