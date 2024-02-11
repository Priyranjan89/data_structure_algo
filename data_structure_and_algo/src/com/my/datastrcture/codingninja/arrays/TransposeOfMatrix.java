package com.my.datastrcture.codingninja.arrays;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6}};
        int m = mat.length;
        int n = mat[0].length;
        printArray(mat);

        int arr[][] = transpose(m, n, mat);
        printArray(arr);
    }
    public static int[][] transpose(int m, int n, int[][] mat) {
        int [][]arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = mat[j][i];
            }
        }
        return arr;
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
