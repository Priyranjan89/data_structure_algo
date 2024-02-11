package com.my.datastrcture.test;

import java.util.HashSet;

public class ArrayIntersection {
    public static void main(String[] args) {

        /*1
4
6 9 8 5
5
9 2 4 1 8
*/
        int a[] = {6,9,8,5};
        int b[] = {9,2,4,1,8};
        intersection(a, b);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        for (int i = arr1.length -1; i >=0; i--) {
            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;

                }
            }
        }
    }

}
