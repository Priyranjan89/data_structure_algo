package com.my.datastrcture.arrays.course;

public class SumOfDiagonalElementIn2dArray {

    public static int sumOfDiagonalElement(int arr[][]){
        int sum =0;
       /* for (int i=0; i<arr.length;i++){
            for (int j=0; j<arr[0].length;j++){
                if (i == j){
                    sum +=arr[i][j];
                }
            }
        }*/

        for (int i=0; i<arr.length;i++){
            sum +=arr[i][i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sumOfDiagonalElement(matrix));
    }
}
