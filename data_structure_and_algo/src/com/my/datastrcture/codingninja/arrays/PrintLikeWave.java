package com.my.datastrcture.codingninja.arrays;

public class PrintLikeWave {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printArray(arr);
        wavePrint(arr);
    }

    public static void wavePrint(int mat[][]){
        int top = 0;
        int bottom = mat.length-1;
        int pos = 0;
        if (bottom <= 0){
            return;
        }
        int col = mat[0].length;
        while (pos < col){
            for (int  i = top; i <= bottom; i++){
                System.out.print(mat[i][pos]+" ");
            }
            pos++;

            if (pos < col){
                for (int i = bottom; i >= 0; i--){
                    System.out.print(mat[i][pos]+" ");
                }
            }
            pos++;
        }
    }

    public static void printArray(int matrix[][]){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
