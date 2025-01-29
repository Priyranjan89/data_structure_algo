package com.my.datastrcture.prectice.leetcode.medium;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 9;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        //Total element
        int n = row * col;

        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;

        while (start <= end){
            //find rowIndex and colIndex using midIndex Value
            int rowIndex = mid/col;
            int colIndex = mid%col;

            if (matrix[rowIndex][colIndex] == target){
                return true;

            } else if (target > matrix[rowIndex][colIndex]) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return false;
    }
}
