package com.my.datastrcture.recursion;

public class FibonacciSeries {

    public static int fibonacci(int n){

        if (n < 0){
            return -1;
        }
        if (n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args){
        int result = fibonacci(6);
        System.out.println(result);
    }
}
