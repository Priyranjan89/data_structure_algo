package com.my.datastrcture.prectice.leetcode.easy;

/*
* The complement of an integer is the integer you get when you flip all the 0's to 1's and
* all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.



Example 1:

Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: n = 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: n = 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.*/

import java.util.Scanner;

public class ComplementOfBase10Integer1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        int ans = bitwiseComplement(n);

        System.out.println("Number n 1st complement = "+ans);
    }

    public static int bitwiseComplement(int n) {
        // Tacking copy of n value
        int m = n;
        int mask = 0;

        //if value of n is 0 than return 1
        if (n == 0){
            return 1;
        }
        //Creating a mask for bits value compare and mask bits will always 1 only
        while (m != 0){
            mask = (mask << 1) | 1;
            m = m >> 1;
        }

        //comparing not(~) of n value with mask bits value
        int ans = (~n) & mask;

        return ans;
    }
}
