package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;
import java.util.Collections;

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
       /* for (int i = 0; i < n; i++){
            ArrayList<Integer> subDp = new ArrayList<>();
            for (int j = 0; j < m; j++){
                subDp.add(-1);
            }
            dp.add(subDp);
        }*/
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies(m, 0)));
        }
        //return helper(n-1, m-1, mat);
        return helperTap(n, m, mat);
    }

    private static int helperTap(int n, int m, ArrayList<ArrayList<Integer>> mat){
        for (int  i = 0; i < m; i++){
            if (mat.get(0).get(i) == -1){
                break;
            }
            mat.get(0).set(i, 1);
        }

        for (int  i = 0; i < n; i++){
            if (mat.get(i).get(0) == -1){
                break;
            }
            mat.get(i).set(0, 1);
        }
        for (int  i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (mat.get(i).get(j) == -1){
                    dp.get(i).set(j, 0);
                } else {
                    dp.get(i).set(j, (dp.get(i-1).get(j) + dp.get(i).get(j-1)) % 1000000007);
                }
            }
        }
        return dp.get(n-1).get(m-1);
    }

    private static int helper(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        if (n == 0 && m == 0){
            return 1;
        }
        if (n < 0 || m < 0){
            return 0;
        }
        if (mat.get(n).get(m) == -1){
            return 0;
        }

        if (dp.get(n).get(m) != -1){
            return dp.get(n).get(m);
        }

        int way1 = helper(n-1, m, mat);
        int way2 = helper(n, m-1, mat);

        int ans = way1 + way2  % 1000000007;;
        dp.get(n).set(m, ans);

        return ans;
    }
}
