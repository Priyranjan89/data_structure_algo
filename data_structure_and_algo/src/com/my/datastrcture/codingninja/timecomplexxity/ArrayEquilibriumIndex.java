package com.my.datastrcture.codingninja.timecomplexxity;

public class ArrayEquilibriumIndex {
    public static void main(String[] args) {
        //int arr[] = {1,4,9,3,2};
        int arr[] = {2, 3, 10, -10, 4, 2, 9};
        System.out.println(arrayEquilibriumIndex(arr));
    }

    public static int arrayEquilibriumIndex(int[] arr){
        int totalSum = 0;

        for(int i = 0; i < arr.length; i++){
            totalSum += arr[i];
        }

        int letSum = 0, index = 0;
        while (index < arr.length){
            int rightSum = totalSum - (letSum + arr[index]);

            if (rightSum == letSum ){
                return index;
            }
            letSum = letSum + arr[index];
            index++;
        }

        return -1;
    }
}
