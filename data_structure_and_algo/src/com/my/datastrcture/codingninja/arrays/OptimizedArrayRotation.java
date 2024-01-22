package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class OptimizedArrayRotation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = {85,65,51};
        System.out.print("Please enter the number of Rotation : ");
        int rotation = sc.nextInt();
        System.out.print("Please enter the Direction as RIGHT and LEFT Only : ");
        String dir = sc.next();
        printArray(arr);
        rotateArray(arr, rotation, dir);
        printArray(arr);


    }

    public static int[] rotateArray(int []a, int x, String dir) {
        int len = a.length;

        if (x > len){
            x = x%len;
        }

        if (dir.equals("RIGHT")){
            reverseArray(a, 0, len-1);
            reverseArray(a, 0, x-1);
            reverseArray(a, x,len-1);
        } else if (dir.equals("LEFT")){
            reverseArray(a, 0, len-1);
            reverseArray(a, 0, len-x-1);
            reverseArray(a, len-x, len-1);
        }
        return a;
    }

    public static void reverseArray(int arr[], int l, int r) {
         l = Math.abs(l);
         r = Math.abs(r);
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
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
