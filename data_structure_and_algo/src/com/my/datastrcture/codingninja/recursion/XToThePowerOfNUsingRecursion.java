package com.my.datastrcture.codingninja.recursion;

public class XToThePowerOfNUsingRecursion {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(power(x,n));
    }

    public static int power(int x, int n) {
        if (n == 0){
            return 1;
        }

        return x * power(x, n-1);
    }
}
