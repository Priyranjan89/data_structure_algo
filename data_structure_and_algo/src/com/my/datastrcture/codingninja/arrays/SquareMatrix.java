package com.my.datastrcture.codingninja.arrays;

public class SquareMatrix {
    public static void main(String[] args) {
        //int arr[][] = {{1, 3, 2}, {4, 5, 5}};
        //int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int arr[][] = {{1, 2}, {2, 1}};
        int n = arr.length;
        int m = arr[0].length;
        int diag[] = new int[m];


        String str = sqrMat(arr, n, m, diag);
        System.out.println(str);
        if (str.equals("YES")){
            for (int i : diag){
                System.out.print(i+" ");
            }
        }
        
    }

    public static String sqrMat(int [][]mat, int n, int m,int diag[]){
        String str = "";

        if (n != m){
            str += "NO";
            return str;
        }else {
            str +="YES";
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == j){
                    diag[i] = mat[i][j];
                }
            }
        }

        return str;
    }
}
