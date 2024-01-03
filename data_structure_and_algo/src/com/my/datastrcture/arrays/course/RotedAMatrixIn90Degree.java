package com.my.datastrcture.arrays.course;

import java.util.ArrayList;
import java.util.List;

public class RotedAMatrixIn90Degree {

    public static void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = matrix[len].length - 1; j >= 0; j--) {
                list.add(matrix[j][i]);
            }
            lists.add(list);
        }

        for (int i =0; i<lists.size(); i++){
            for (int j =0; j<lists.get(0).size(); j++){
                matrix[i][j] = lists.get(i).get(j);
                //System.out.print( matrix[i][j]+" ");
            }
            //System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        //[[7,4,1],[8,5,2],[9,6,3]]
    }
}
