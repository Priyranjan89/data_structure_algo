package com.my.datastrcture.codingninja.dp;

public class RobCuttingProblem {
    public static void main(String[] args) {
        int price[] = {2,5,7,8,10};
        int price2[] = {3,5,8,9,10,17,17,20};
        int n = 5;
        int n2 = 8;
        System.out.println(cutRod(price, n));
        System.out.println(cutRod(price2, n2));
    }
    public static int cutRod(int price[], int n) {
        int val[] = new int[n+1];
        val[0] = 0;

        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }
}
