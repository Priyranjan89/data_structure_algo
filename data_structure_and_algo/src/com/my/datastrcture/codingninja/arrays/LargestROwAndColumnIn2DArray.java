/*For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest sum(sum of all the elements in a row or column) amongst all the rows/columns.

Note :
If there are more than one rows/columns with maximum sum, consider the row/column that comes first. And if ith row and jth column has the same largest sum, consider the ith row as answer.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'M' column values separated by a single space.
Output Format :
For each test case, If row sum is maximum, then print: "row" <row_index> <row_sum>
OR
If column sum is maximum, then print: "column" <col_index> <col_sum>
It will be printed in a single line separated by a single space between each piece of information.

Output for every test case will be printed in a seperate line.
 Consider :
If there doesn't exist a sum at all then print "row 0 -2147483648", where -2147483648 or -2^31 is the smallest value for the range of Integer.*/

package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class LargestROwAndColumnIn2DArray {

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

       // int arr[][] = {{5,2,1,3}, {4,6,8,7}, {0,2,9,1}, {5,7,6,4}};
        int arr[][] = takeInput();
        findLargest(arr);
    }

    public static void findLargest(int mat[][]){
        int result = Integer.MIN_VALUE;
        String rowOrCol = "";
        int index = 0;

        int row = mat.length;
        if (row == 0){
            printLargest(result, rowOrCol, index);
            return;
        }
        int col = mat[0].length;

        for (int i = 0; i < row; i++){
            int sum = 0;
            for (int j = 0; j < col; j++){
                sum += mat[i][j];
            }
            if (sum > result){
                result = sum;
                rowOrCol = "row";
                index = i;
            }
        }

        for (int i = 0; i < col; i++){
            int sum = 0;
            for (int j = 0; j < row; j++){
                sum += mat[j][i];
            }
            if (sum > result){
                result = sum;
                rowOrCol = "column";
                index = i;
            }
        }

        printLargest(result, rowOrCol, index);
    }

    public static void printLargest(int result, String rowOrCol, int index) {
        if (rowOrCol.length() > 0){
            System.out.println(rowOrCol +" "+ index +" "+ result);
        } else {
            rowOrCol = "row";
            System.out.println(rowOrCol +" "+ index +" "+ result);
        }
    }
}
