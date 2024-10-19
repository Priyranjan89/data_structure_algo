package com.my.datastrcture.leetcode.medium;

public class DivideTwoIntegers29 {
    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = -1;
        System.out.println(divide(dividend, divisor)); // Output: 3

        dividend = 7;
        divisor = -3;
        System.out.println(divide(dividend, divisor)); // Output: -2

        dividend = Integer.MIN_VALUE;
        divisor = -1;
        System.out.println(divide(dividend, divisor)); // Output: Integer.MAX_VAL
    }

    public static int divide(int dividendx, int divisorx) {

        if (dividendx == Integer.MIN_VALUE && divisorx == -1){
            return Integer.MAX_VALUE;
        }

        boolean ans_pos_sign = true;
        if ((dividendx < 0 && divisorx > 0) || (dividendx > 0 && divisorx < 0)){
            ans_pos_sign = false;
        }

        // now i can divide with BS using only pos number;
        long dividend = Math.abs((long)dividendx);
        long divisor = Math.abs((long)divisorx);
        long start = 0;
        long end = dividend;
        long ans = 0;

        long mid = start + ((end - start)>>1);

        while (start <= end){
            if (mid * divisor <= dividend){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + ((end - start)>>1);
        }

        if (!ans_pos_sign) {
            ans = -ans;
        }
        return  (int)ans;
    }

    public static int divide2(int dividendx, int divisorx) {
        // Handle edge case for overflow
        if (dividendx == Integer.MIN_VALUE && divisorx == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean ans_pos_sign = true;
        if (dividendx < 0 && divisorx > 0) {
            ans_pos_sign = false;
        }
        if (dividendx > 0 && divisorx < 0) {
            ans_pos_sign = false;
        }

        // Use absolute values for division
        long dividend = Math.abs((long) dividendx);
        long divisor = Math.abs((long) divisorx);
        long s = 0, e = dividend;
        long ans = 0;

        // Binary search for the quotient
        while (s <= e) {
            long mid = s + ((e - s) >> 1);

            // Check if mid is a valid quotient
            if (mid * divisor <= dividend) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        // Apply the sign to the result
        if (!ans_pos_sign) {
            ans = -ans;
        }

        // Ensure the result is within the 32-bit signed integer range
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) ans;
    }
}
