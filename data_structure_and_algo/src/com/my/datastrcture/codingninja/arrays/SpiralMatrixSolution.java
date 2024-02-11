package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class SpiralMatrixSolution {

    public static int[][] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of row: " );
        int row = sc.nextInt();
        System.out.print("Please enter the number of Column: " );
        int col = sc.nextInt();

        int arr[][] = new int[row][col];

        return arr;
    }
    public static void main(String[] args) {
        //int arr[][] = {{1,2,3,4,5}, {16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
       /* int arr[][] = {{1,2,3,4,5,6},
                     {18,19,20,21,22,7},
                     {17,28,29,30,23,8},
                     {16,27,26,25,24,9},
                     {15,14,13,12,11,10}};*/
        int arr[][] = takeInput();
        printArray(arr);
        spiralPrint(arr);
    }

    public static void spiralPrint(int matrix[][]){
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        if (bottom <= 0){
            return;
        }
        int right = matrix[0].length-1;

        while (left <= right && top <= bottom){
            for (int  i = left; i <= right; i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;

            for (int  i = top; i <= bottom; i++){
                System.out.print(matrix[i][right]+" ");
            }
            right--;

            if (top <= bottom){
                for (int  i = right; i >= left; i--){
                    System.out.print(matrix[bottom][i]+" ");
                }
            }
            bottom--;

            if (left <= right){
                for (int  i = bottom; i >= top; i--){
                    System.out.print(matrix[i][left]+" ");
                }
            }
            left++;
        }
    }

    public static void printArray(int matrix[][]){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
