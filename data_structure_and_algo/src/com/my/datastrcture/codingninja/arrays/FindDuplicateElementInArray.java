package com.my.datastrcture.codingninja.arrays;

public class FindDuplicateElementInArray {
    public static void main(String[] args) {
        int arr[] = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        System.out.println("Find Duplicate Value In Array : "+duplicateNumber(arr));
    }

    public static int duplicateNumber(int arr[]) {

        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if ( arr[i] == arr[j]){
                   return arr[i];
                }
            }
        }
        return -1;
    }
}
