package com.my.datastrcture.codingninja.arrays;

public class RowWiseSum {
    public static void main(String[] args) {
        int mat[][] = {{1,2},{3,4},{5,6},{7,8}};
        printArray(mat);
        rowWiseSum(mat);
    }

    public static void rowWiseSum(int[][] mat) {
        int n = mat.length;
        if(n <= 0){
            return;
        }
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++){
                sum += mat[i][j];
            }
            System.out.print(sum+" ");
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
