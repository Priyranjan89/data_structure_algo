package com.my.datastrcture.prectice.dp;

public class MaxPathSum {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}};
        int matrix2[][] = {{10,10,2,-13,20,4},
                {1,-9,-81,30,2,5},
                {0,10,4,-79,2,-10},
                {1,-5,2,20,-11,4}};
        //System.out.println(getMaxPathSum(matrix));
        System.out.println(getMaxPathSum(matrix));
        System.out.println(getMaxPathSum(matrix2));
    }

    private static int dp[][];
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }


       /* int ans = Integer.MIN_VALUE;
        for (int  i =0; i < m; i++){
            ans = Math.max(ans, helper(matrix, 0 , i, n, m));
        }
        return ans;*/

        return helperTap(matrix, n, m);
    }

    //Memoization
    private static int helper(int[][] matrix, int x, int y, int n, int m) {
        if (x == n){
            return 0;
        }

        if (x < 0 || x >= n || y < 0 || y >= m){
            return 0;
        }

        if (dp[x][y] != -1){
            return dp[x][y];
        }

        int ch1, ch2, ch3;
        ch1 = matrix[x][y] + helper(matrix, x+1, y, n, m);
        ch2 = matrix[x][y] + helper(matrix, x+1, y+1, n, m);
        ch3 = matrix[x][y] + helper(matrix, x+1, y-1, n, m);

        int ans = Math.max(ch1, Math.max(ch2, ch3));
        dp[x][y] = ans;

        return ans;
    }

    //Tabulation
    private static int helperTap(int matrix[][], int n, int m){
        for (int  i = 0; i < m; i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                int ch1, ch2 = Integer.MIN_VALUE, ch3 = Integer.MIN_VALUE;
                ch1 = matrix[i][j] + dp[i-1][j];
                if (j != 0){
                    ch2 = matrix[i][j] + dp[i-1][j-1];
                }
                if (j != m-1){
                    ch2 = matrix[i][j] + dp[i-1][j+1];
                }
                dp[i][j] = Math.max(ch1, Math.max(ch2, ch3));
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++){
            ans = Math.max(ans, dp[n-1][i]);
        }
        return ans;
    }

    public static int findMaxSumPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // DP array to store maximum sum path for each cell
        int[][] dp = new int[rows][cols];

        // Initialize the last row of DP array with matrix values
        for (int j = 0; j < cols; j++) {
            dp[rows - 1][j] = matrix[rows - 1][j];
        }

        // Iterate from bottom to top to find maximum sum path
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int maxPath = dp[i + 1][j]; // Move directly down
                if (j > 0) {
                    maxPath = Math.max(maxPath, dp[i + 1][j - 1]); // Move diagonally down-left
                }
                if (j < cols - 1) {
                    maxPath = Math.max(maxPath, dp[i + 1][j + 1]); // Move diagonally down-right
                }
                dp[i][j] = maxPath + matrix[i][j]; // Update maximum sum path for current cell
            }
        }

        // Find maximum sum path in the first row
        int maxSum = dp[0][0];
        for (int j = 1; j < cols; j++) {
            maxSum = Math.max(maxSum, dp[0][j]);
        }

        return maxSum;
    }
}
