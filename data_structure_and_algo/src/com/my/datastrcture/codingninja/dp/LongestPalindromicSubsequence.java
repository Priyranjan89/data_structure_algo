package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "bbabcbcab";
        System.out.println(longestPalindromeSubsequence(str));
    }
    private static ArrayList<ArrayList<Integer>> dp;
    public static int longestPalindromeSubsequence(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int m = rev.length();
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>(m+1);
            for (int j = 0; j <= m+1; j++){
                row.add(0); //Tab
            }
            dp.add(row);
        }
        return helperTap(s, rev, n, m);
    }

    private static int helperTap(String s, String t, int n, int m){
        /*for (int i = 0;i<=m;i++){
            dp.get(0).set(i,0);
        }
        for (int i = 0;i<=n;i++){
            dp.get(i).set(0,0);
        }*/
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    int temp = 1 + dp.get(i-1).get(j-1);
                    dp.get(i).set(j, temp);
                } else {
                    int temp = Math.max(dp.get(i-1).get(j), dp.get(i).get(j-1));
                    dp.get(i).set(j, temp);
                }
            }
        }
        return dp.get(n).get(m);
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
