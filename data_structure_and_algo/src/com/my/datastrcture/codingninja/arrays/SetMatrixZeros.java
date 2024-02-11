package com.my.datastrcture.codingninja.arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        //int arr[][] = {{7, 19, 3}, {4, 21, 0}};
        int arr[][] = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        //int arr[][] = {{0, 2, 3}, {1, 0, 3}, {1, 2, 0}};
        setZeros(arr);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void setZeros(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean zerosRow[] = new boolean[row];
        boolean zerosCol[] = new boolean[col];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    zerosRow[i] = true;
                    zerosCol[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (zerosRow[i] || zerosCol[j]){
                   matrix[i][j] = 0;
                }
            }
        }
    }
}
