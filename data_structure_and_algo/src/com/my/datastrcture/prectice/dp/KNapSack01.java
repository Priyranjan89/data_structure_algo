package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;

public class KNapSack01 {
    public static void main(String[] args) {
        int weight[] = {1,2,4,5};
        int value[] = {5,4,8,6};
        int n = 4;
        int maxWeight = 5;
        System.out.println(knapsack(weight, value, n, maxWeight));
    }

    private static ArrayList<ArrayList<Integer>> dp;
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        dp = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++){
            ArrayList<Integer> row = new ArrayList<>(maxWeight+1);
            for (int j = 0; j <=maxWeight; j++){
                row.add(-1);
            }
            dp.add(row);
        }
        //return helper(weight, value, n-1, maxWeight);
        return helperTap(weight, value, n, maxWeight);
    }

    private static int helper(int[] weight, int[] value, int index, int w) {
        if (index < 0){
            return 0;
        }

        if (dp.get(index).get(w) != -1){
            return dp.get(index).get(w);
        }

        int take = Integer.MIN_VALUE, not_take;

        not_take = helper(weight, value, index-1, w);
        if (weight[index] <= w){
            take = helper(weight, value, index-1,w - weight[index]) + value[index];
        }
        int temp = Math.max(take, not_take);
        dp.get(index).set(w, temp);

        return temp;
    }
    private static int helperTap(int[] weight, int[] value, int n, int w) {
        for (int i = 0; i <= w; i++){
            dp.get(0).set(i, 0);
        }

        for (int i = 0; i <= n; i++){
            dp.get(i).set(0, 0);
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= w; j++){
                int take = Integer.MIN_VALUE, not_take;
                not_take = dp.get(i-1).get(j);
                if (weight[i-1] <= j){
                    take = value[i-1] + dp.get(i-1).get(j - weight[i-1]);
                }
                dp.get(i).set(j, Math.max(take, not_take));
            }

        }
        return dp.get(n).get(w);
    }
}
