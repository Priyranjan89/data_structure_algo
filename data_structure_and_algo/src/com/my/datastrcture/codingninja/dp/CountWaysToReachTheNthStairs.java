package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class CountWaysToReachTheNthStairs {
    public static void main(String[] args) {
        System.out.println(countDistinctWayToClimbStair(51));
        System.out.println(countDistinctWayToClimbStair(76));
    }

    public static long countDistinctWayToClimbStair(int nStairs){
        if (nStairs <= 1){
            return 1;
        }
        int stairs = nStairs;
        long distinctWays[] = new long[stairs+1];
        distinctWays[0] = 1;
        distinctWays[1] = 1;
        for (int i = 2; i <= stairs; i++){
            distinctWays[i] = (distinctWays[i - 1] + distinctWays[i - 2]) % (1000000000 + 7);
        }
        return distinctWays[nStairs];
    }

    public static long countDistinctWayToClimbStairX(int nStairs) {
        ArrayList<Long> dp = new ArrayList<>(nStairs+1);

        for (long i = 0; i <= nStairs; i++){
            dp.add(-1l);
        }
        return staircase(nStairs, dp);
    }

    private static int MOD = 1000000007;
    private static long staircase(int nStairs,  ArrayList<Long> dp){
        if (nStairs == 0){
            return 1;
        }
        if (nStairs < 0){
            return 0;
        }
        if (dp.get(nStairs)  != -1){
            return dp.get(nStairs);
        }
        long temp =  (staircase(nStairs-1, dp) + staircase(nStairs - 2, dp)) % MOD;
        dp.set(nStairs, temp);
        return temp;
    }


}
