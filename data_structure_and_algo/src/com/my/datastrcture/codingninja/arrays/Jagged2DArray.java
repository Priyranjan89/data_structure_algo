package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class Jagged2DArray {
    public static void main(String[] args) {
        int arr[][] = takeInput();
        printArray(arr);
    }
    public static int[][] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of row: " );
        int row = sc.nextInt();

        int arr[][] = new int[row][];

        for (int i = 0; i < arr.length; i++){
            System.out.print("Please enter the number of Column: " );
            int col = sc.nextInt();
            int a[] = new int[col];
            System.out.print("Please enter the value: " );
            for (int j = 0; j < a.length; j++){
                a[j] = sc.nextInt();;
            }
            arr[i] = a;
        }

        return arr;
    }

    public static void printArray(int arr[][]){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
