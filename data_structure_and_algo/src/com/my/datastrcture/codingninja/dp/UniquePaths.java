package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class UniquePaths {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();
        ArrayList<Integer> row3 = new ArrayList<>();
        int n = 3;
        int m = 3;

        row1.add(0);
        row1.add(0);
        row1.add(0);
        row2.add(0);
        row2.add(-1);
        row2.add(0);
        row3.add(0);
        row3.add(0);
        row3.add(0);
        mat.add(row1);
        mat.add(row2);
        mat.add(row3);
        System.out.println(mazeObstacles(n, m, mat));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        dp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++){
                row.add(-1);
            }
            dp.add(row);
        }
        return helper(n-1, m-1, mat);
       // return helperTap(n, m, mat);
    }
    private static int helperTap(int n, int m, ArrayList<ArrayList<Integer>> mat){
        for (int i = 0; i < m; i++){
            if (mat.get(0).get(i) == -1){
                break;
            }
            dp.get(0).set(i, 1);
        }
        for (int i = 0; i < n; i++){
            if (mat.get(i).get(0) == -1){
                break;
            }
            dp.get(i).set(0, 1);
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (mat.get(i).get(j) == -1){
                    dp.get(i).set(j, 0);
                } else {
                    dp.get(i).set(j, dp.get(i-1).get(j) + dp.get(i).get(j-1));
                }
            }
        }
        return dp.get(n-1).get(m-1);
    }

    private static int helper(int i, int j, ArrayList<ArrayList<Integer>> mat){
        if (i == 0 && j == 0){
            return 1;
        }
        if (i < 0 || j < 0){
            return 0;
        }
        if (mat.get(i).get(j) == -1){
            return 0;
        }

        if (dp.get(i).get(j) != -1){
            return dp.get(i).get(j);
        }

        int way1, way2;
        way1 = helper(i-1, j , mat);
        way2 = helper(i, j-1 , mat);

        int ans  = (way1 + way2) % 1000000007;
        dp.get(i).set(j, ans);

        return ans;
    }
}
