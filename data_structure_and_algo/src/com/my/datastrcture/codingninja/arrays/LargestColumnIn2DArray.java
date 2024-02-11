package com.my.datastrcture.codingninja.arrays;

public class LargestColumnIn2DArray {
    public static void main(String[] args) {
        int arr[][] = {{5,2,1,3}, {4,6,8,7}, {0,2,9,1}, {5,7,6,4}};

        //int result[] = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Sum of Largest Column in 2d Array : " + sumColumn(arr));

    }

    public static int sumColumn(int arr[][]){
        int row = arr.length;
        int col = arr[0].length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < col; i++){
            int sum = 0;
            for (int j = 0; j < row; j++){
                sum += arr[j][i];
            }
           if (sum > result){
               result = sum;
           }
        }
        return result;
    }
}
