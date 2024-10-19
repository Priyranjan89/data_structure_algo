package com.my.datastrcture.codingninja.dp;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String a1 = "brute";
        String b1 = "groot";
        System.out.println(shortestSupersequence(a1, b1)); // Output: bgruoote

        String a2 = "bleed";
        String b2 = "blue";
        System.out.println(shortestSupersequence(a2, b2)); // Output: bleued

        String a3 = "coding";
        String b3 = "ninjas";
        System.out.println(shortestSupersequence(a3, b3)); // Output: codningjas

        String a4 = "blinding";
        String b4 = "lights";
        System.out.println(shortestSupersequence(a4, b4)); // Output: blindinghts
    }

    public static String shortestSupersequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (ch1[i - 1] == ch2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        int i = m, j = n;
        String scs = "";
        while (i > 0 && j > 0) {
            if (ch1[i - 1] == ch2[j - 1]) {
                scs = ch1[i - 1] + scs;
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                scs = ch1[i - 1] + scs;
                i--;
            } else {
                scs = ch2[j - 1] + scs;
                j--;
            }
        }

        while (i > 0) {
            scs = ch1[i - 1] + scs;
            i--;
        }

        while (j > 0) {
            scs = ch2[j - 1] + scs;
            j--;
        }

        return scs;
    }

}
