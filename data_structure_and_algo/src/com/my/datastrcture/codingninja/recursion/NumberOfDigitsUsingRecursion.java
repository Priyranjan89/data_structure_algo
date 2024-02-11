package com.my.datastrcture.codingninja.recursion;

public class NumberOfDigitsUsingRecursion {
    public static void main(String[] args) {
        int n = 948103;
        System.out.println(countDigits(n));
    }

    public static int countDigits(int n){
        if (n == 0){
            return 0;
        }

        int count = countDigits(n/10);
        count++;
        return count;
    }
}
