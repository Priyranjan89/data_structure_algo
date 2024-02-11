package com.my.datastrcture.codingninja.arrays;

public class TotalSumOnTheBoundariesAndDiagonals {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        printArray(arr);
        totalSum(arr);

    }
    public static void totalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || i == n-1 || j == 0 || j == n-1) {
                    sum +=mat[i][j];
                }

            }
            for (int j = 0; j < n; j++){
                if (i == j && i !=0 && i != n-1){
                    sum += mat[i][j];
                }
            }

            for (int j = 0; j < n; j++){
                if ( i+j == n-1 && i !=0 && i != n-1 && i !=j){
                    sum += mat[i][j];
                }
            }

        }
        System.out.println(sum);
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
