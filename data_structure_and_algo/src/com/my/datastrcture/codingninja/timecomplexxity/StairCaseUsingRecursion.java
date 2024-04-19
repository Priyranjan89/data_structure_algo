package com.my.datastrcture.codingninja.timecomplexxity;

public class StairCaseUsingRecursion {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(staircase(n));

    }

    public static int staircase(int n){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        return (staircase(n-1) + staircase(n - 2) + staircase(n - 3));
    }
}
