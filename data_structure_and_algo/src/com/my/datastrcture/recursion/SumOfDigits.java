package com.my.datastrcture.recursion;

public class SumOfDigits {

    public static int sumOfDigits(int n) {
        if (n == 0 || n < 0) {
            return 0;
        }
       /* if (n == 1) {
            return 1;
        }*/
        //int rem = n % 10;

        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(190));
        System.out.println(sumOfDigits(10));
        System.out.println(sumOfDigits(199));
        System.out.println(sumOfDigits(992));
    }
}
