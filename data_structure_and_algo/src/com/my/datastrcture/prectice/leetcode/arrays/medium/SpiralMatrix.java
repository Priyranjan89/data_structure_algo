package com.my.datastrcture.prectice.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        //int arr[][] = {{1,2,3,4,5}, {16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        int arr[][] = {{1}};
        printArray(arr);
        List<Integer> list = spiralOrder(arr);
        for (int i : list){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;

        int right = matrix[0].length-1;

        while (left <= right && top <= bottom){
            for (int  i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            for (int  i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom){
                for (int  i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if (left <= right){
                for (int  i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }

        return list;
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
