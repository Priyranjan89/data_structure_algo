package com.my.datastrcture.codingninja.recursion;

import java.util.Scanner;

public class SumOfDigitsUsingRecursion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(sumOfDigits(n));
    }

    public static int sumOfDigits(int input){
        if (input == 0){
            return 0;
        }
        int rem = input % 10;

        return rem + sumOfDigits(input/10);
    }
}
