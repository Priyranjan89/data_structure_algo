package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Scanner;

/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
*/
public class ReverseInteger7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of X");
        int x = sc.nextInt();
        int ans = reverse( x);
        System.out.println("Reverse number of "+x+" is "+ans);
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x !=0 ){
            int rem = x%10;
            if ((ans > Integer.MAX_VALUE/10) || (ans < Integer.MIN_VALUE/10)){
                return 0;
            }
            ans = (ans*10)+rem;
            x = x/10;
        }
        return ans;
    }
}
