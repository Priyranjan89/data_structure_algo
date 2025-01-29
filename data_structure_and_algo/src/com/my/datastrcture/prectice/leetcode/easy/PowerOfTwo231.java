package com.my.datastrcture.prectice.leetcode.easy;

/*Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.



Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false


Constraints:

-231 <= n <= 231 - 1*/

import java.util.Scanner;

public class PowerOfTwo231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        System.out.println("Number is Power of two : "+isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {

       /* for (int i = 0; i <= 30; i++){
            int ans = (int) Math.pow(2,i);

            if (n == ans){
                return true;
            }
        }*/

        /*int ans = 1;

        for (int i = 0; i <= 30; i++) {
            if (n == ans) {
                return true;
            }
            if (ans < Integer.MAX_VALUE/2){
                ans = ans * 2;
            }

        }*/

        int count = 0;
        while (n > 0 ){
            count += n & 1;
            n >>= 1;
        }
        if (count == 1){
            return true;
        }
        return false;

       // return n > 0 && (n & (n - 1)) == 0;
    }
}
