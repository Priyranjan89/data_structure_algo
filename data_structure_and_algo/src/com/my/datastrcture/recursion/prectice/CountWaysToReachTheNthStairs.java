package com.my.datastrcture.recursion.prectice;

public class CountWaysToReachTheNthStairs {
    public static void main(String[] args) {
        int nStairs = 5;
        System.out.println(countDistinctWayToClimbStair(nStairs));
    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        if (nStairs < 0){
            return 0;
        }
        if (nStairs == 0){
            return 1;
        }
        long ans = countDistinctWayToClimbStair(nStairs - 1) +
                countDistinctWayToClimbStair(nStairs - 2);

        return (int) ans;
    }
}
