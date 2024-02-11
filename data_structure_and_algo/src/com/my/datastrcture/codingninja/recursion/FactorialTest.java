package com.my.datastrcture.codingninja.recursion;

public class FactorialTest {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(5));
    }

    public static int fact(int n){
        if (n == 0){
            return 1;
        }

        return n * fact(n-1);
    }
}
