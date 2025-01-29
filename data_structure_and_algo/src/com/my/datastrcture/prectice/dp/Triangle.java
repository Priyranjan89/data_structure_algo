package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;
import java.util.Collections;

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

    //Memoization
    public static int minimumPathSum1(int[][] triangle, int n) {
        dp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            dp.add(new ArrayList<>(Collections.nCopies(n, -1)));
        }
        return helper(triangle, n, 0, 0);
    }

    public static int helper(int[][] triangle, int n, int row, int col) {
        if (row == n-1){
            return triangle[n-1][col];
        }

        if (dp.get(row).get(col) != -1){
            return dp.get(row).get(col);
        }

        int opt1 = triangle[row][col] + helper(triangle, n, row+1, col);
        int opt2 = triangle[row][col] + helper(triangle, n, row+1, col+1);

        int ans = Math.min(opt1, opt2);
        dp.get(row).set(col, ans);

        return ans;
    }

    //Tabulation
    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][] = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++){
            for (int j = 0; j <= i; j++){
                int opt1 = Integer.MAX_VALUE, opt2 = Integer.MAX_VALUE;
                if (j != i){
                    opt1 = triangle[i][j] + dp[i-1][j];
                }
                if (j != 0){
                    opt2 = triangle[i][j] + dp[i-1][j-1];
                }
                dp[i][j] = Math.min(opt1, opt2);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
         return ans;
    }
}
