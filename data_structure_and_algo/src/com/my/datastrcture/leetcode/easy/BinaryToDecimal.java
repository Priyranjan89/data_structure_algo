package com.my.datastrcture.leetcode.easy;

import java.util.Scanner;

import static java.lang.Math.pow;

public class BinaryToDecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        int ans = 0;
        int i =0;

        while (n != 0){
            int rem = n%10;

            if (rem == 1) {
                ans = (int) (ans+pow(2,i));
            }

            n = n/10;
            i++;
        }

        System.out.println("Decimal number of n is "+ans);
    }
}
