package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;

public class CountWaysToReachTheNthStairs {

    public static void main(String[] args) {
        System.out.println(countDistinctWayToClimbStair(4));
        System.out.println(countDistinctWayToClimbStair(5));
        System.out.println(countDistinctWayToClimbStair2(5));
    }


    static ArrayList<Long> dp;
    private static int MOD = 1000000007;
    //Memoization
    public static long countDistinctWayToClimbStair(int nStairs) {
        dp = new ArrayList<>(nStairs+1);
        for (long i = 0; i <= nStairs; i++){
            dp.add(-1l);
        }
        return stairCaseHelper(nStairs, dp);
    }

    private static long stairCaseHelper(int nStairs, ArrayList<Long> dp) {
        if (nStairs == 0){
            return 1;
        }
        if (nStairs < 0){
            return 0;
        }
        if (dp.get(nStairs) != -1l){
            return dp.get(nStairs);
        }

        long temp = (stairCaseHelper(nStairs-1, dp) + stairCaseHelper(nStairs-2, dp)) % MOD;
        dp.add(temp);
        return temp;
    }

    //Tabulation
    public static long countDistinctWayToClimbStair2(int nStairs) {
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

}
