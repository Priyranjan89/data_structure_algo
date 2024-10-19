package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class Triangle {
    public static void main(String[] args) {
        int triangle[][] = {{2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}};
        int n = 4;
        System.out.println(minimumPathSum(triangle, n));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int minimumPathSum(int[][] triangle, int n) {
        dp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++){
                row.add(-1);
            }
            dp.add(row);
        }
        //return helper(triangle, n, 0, 0);
        return helperTap(triangle, n);
    }
    private static int helper(int[][] triangle, int n, int row, int col){
        if (row == n-1){
            return triangle[n-1][col];
        }
        if (dp.get(row).get(col) != -1){
            return dp.get(row).get(col);
        }

        int op1, op2;
        op1 = triangle[row][col] + helper(triangle, n, row+1, col);
        op2 = triangle[row][col] + helper(triangle, n, row+1, col+1);

        int ans = Math.min(op1, op2);
        dp.get(row).set(col, ans);

        return ans;
    }
    private static int helperTap(int[][] arr, int n){
        dp.get(0).set(0, arr[0][0]);

        for (int i = 1; i < n; i++){
            for (int j = 0; j <= i; j++){
                int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
                if (j!=i)
                    op1 = arr[i][j] + dp.get(i-1).get(j);
                if (j != 0)
                    op2 = arr[i][j] + dp.get(i-1).get(j-1);
                dp.get(i).set(j, Math.min(op1, op2));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, dp.get(n-1).get(i));
        }
        return ans;
    }
}
