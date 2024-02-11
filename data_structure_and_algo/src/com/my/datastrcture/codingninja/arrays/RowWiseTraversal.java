package com.my.datastrcture.codingninja.arrays;

public class RowWiseTraversal {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int ans[] = printRowWise(a);
        for( int i : ans){
            System.out.print(i+" ");
        }
    }

    public static int[] printRowWise(int [][]a) {
        int len = a.length * a[0].length;
        int arr[] = new int[len];
        int k = 0;

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j <a[i].length; j++){
                arr[k] = a[i][j];
                k++;
            }
        }

        return arr;
    }
}
