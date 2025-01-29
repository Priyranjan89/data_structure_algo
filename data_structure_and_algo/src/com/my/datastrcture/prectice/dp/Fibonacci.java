package com.my.datastrcture.prectice.dp;

import java.util.ArrayList;

public class Fibonacci {
    private  static ArrayList<Integer> dp;
    public static void main(String[] args) {
        dp = new ArrayList<>();
        int n = 5;
        for (int i = 0; i <= n; i++){
            dp.add(-1);
        }
        System.out.println(fibonacci(n));
        System.out.println(fibonacci2(n));
    }

    //Memoization
    private static int fibonacci(int n){
        if (n <=1 ){
            return n;
        }
        if (dp.get(n) != -1){
            return dp.get(n);
        }

        int temp = fibonacci(n-1) + fibonacci(n-2);
        dp.add(temp);

        return temp;
    }

    //Tabulation
    private static int fibonacci2(int n){
        dp.set(0, 0);
        dp.set(1, 1);

        for (int i = 2; i <= n; i++){
            dp.set(i, dp.get(i-1) + dp.get(i-2));
        }
        return dp.get(n);
    }
}
