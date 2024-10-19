package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "adebc";
        String str2 = "dcadb";
        System.out.println(lcs(str1, str2));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>(m+1);
            for (int j = 0; j <= m+1; j++){
                row.add(-1); //Tab
            }
            dp.add(row);
        }
        //return helperMemo(s, t, n-1, m-1);
        return helperTap(s, t, n, m);
    }
    private static int helperMemo(String s, String t, int idx1, int idx2){
        if (idx1 < 0 || idx2 < 0)
            return 0;
        if (dp.get(idx1).get(idx2) != -1)
            return dp.get(idx1).get(idx2);

        if (s.charAt(idx1) == t.charAt(idx2)){
            int temp = 1 + helperMemo(s, t, idx1-1, idx2-1);
            dp.get(idx1).set(idx2, temp);
            return temp;
        } else {
            int temp = Math.max(helperMemo(s, t, idx1-1, idx2), helperMemo(s, t, idx1, idx2-1));
            dp.get(idx1).set(idx2, temp);
            return temp;
        }
    }

    private static int helperTap(String s, String t, int n, int m){
        for (int i = 0;i<=m;i++){
            dp.get(0).set(i,0);
        }
        for (int i = 0;i<=n;i++){
            dp.get(i).set(0,0);
        }
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
}
