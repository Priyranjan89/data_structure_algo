package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class RotationInArryWithNew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*5
5 6 LEFT
20 6 9 68 61
3 4 RIGHT
85 65 51
2 8 RIGHT
98 83
3 4 LEFT
38 98 40
7 10 LEFT
52 11 77 98 41 89 97
*/

        int arr[] = {20, 6, 9, 68, 61};
        System.out.print("Please enter the number of Rotation : ");
        int rotation = sc.nextInt();
        System.out.print("Please enter the Direction as RIGHT and LEFT Only : ");
        String dir = sc.next();
        printArray(arr);
        rotateArray(arr, rotation, dir);
        printArray(arr);
    }

    public static int[] rotateArray(int []a, int x, String dir){
        int len = a.length;

        if (x > len){
            x = x%len;
        }
        int b[] = new int[a.length];
        if (dir.equals("RIGHT")){
            for (int i = 0; i < len; i++){
                int position = (i + x) % len;
                b[position] = a[i];
            }
        } else if (dir.equals("LEFT")){
            for (int i = 0; i < len; i++){
                int position = (i - x + len) % len;
                b[position] = a[i];
            }
        }

        return b;
    }
    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
