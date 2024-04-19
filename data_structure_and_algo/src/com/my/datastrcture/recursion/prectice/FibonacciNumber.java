package com.my.datastrcture.recursion.prectice;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(fib(n));

    }

    public static int fib(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0 || n == 1){
            return n;
        }

        return fib(n-1) + fib(n - 2);
    }
}
