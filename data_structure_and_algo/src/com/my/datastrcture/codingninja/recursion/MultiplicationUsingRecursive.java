package com.my.datastrcture.codingninja.recursion;

public class MultiplicationUsingRecursive {
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        System.out.println(multiplyTwoIntegers(n,m));
    }

    public static int multiplyTwoIntegers(int m, int n){
        if (n == 0){
            return 0;
        }

        return m + multiplyTwoIntegers(m, n-1);
    }
}
