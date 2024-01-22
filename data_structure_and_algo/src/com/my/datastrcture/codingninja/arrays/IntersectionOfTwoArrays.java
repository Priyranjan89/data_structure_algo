package com.my.datastrcture.codingninja.arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 3, 4, 7 };
        int arr3[] = {10, 10};
        int arr4[] = {10};
        intersections(arr1, arr2);
        intersections(arr3, arr4);
    }

    public static void intersections(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    System.out.print(arr1[i]+" ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }
}
