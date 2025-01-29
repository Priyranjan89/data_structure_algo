package com.my.datastrcture.prectice.leetcode.easy;

/*Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 231 - 1*/

public class SqrtRoot69 {
    public static void main(String[] args) {
        int n = 54;
        int tempSol = mySqrt(n);
        System.out.println("Sqrt of "+n+" is "+tempSol);

        double morePrecision = morePrecision(n, 3, tempSol);
        System.out.println("Sqrt of Precision for "+n+" is "+morePrecision);
        System.out.println(mySqrt2(100));

        n = 63;
        double ans = myPrecisionSqrt(n); // TC: O(log n) + O(Precision).
        System.out.printf("M1: Precision Sqrt: %.9f\n", ans);

        ans = BSPrecision(n);
        System.out.printf("M2: Precision Sqrt: %.9f\n", ans);
    }

    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        int mid = start + (end - start)/2;
        int ans = -1;

        if (x == 0 || x == 1)
            return x;

        while (start <= end) {

            if ((long) mid * mid > (long) x) {
                end = mid - 1;
            } else if (mid * mid == x) {
                // If the square of the middle value is equal to x, we found the square root.
                return mid;
            } else {
                // If the square of the middle value is less than x, move the "start" to the right (mid + 1).
                start = mid + 1;
                ans = mid;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static int mySqrt2(int x) {
        int start = 0;
        int end = x;
        int mid = start + (end - start)/2;
        int ans = -1;

        if (x == 0 || x == 1)
            return x;

        while (start <= end) {

            if (mid * mid == x){
                return mid;
            }
            if ((long) mid*mid < (long) x){
                ans = mid;
                start = mid+1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static double morePrecision(int n, int precision, int tempSol){
        double factor = 1;
        double ans = tempSol;

        for (int i = 0; i < precision; i++){
            factor = factor/10;

            for (double j = ans; j * j < n; j = j+factor){
                ans = j;
            }
        }

        return ans;
    }

    public static double myPrecisionSqrt(int n) {
        double sqrt = mySqrt(n); // O(log n) for integer part

        int precision = 9;
        double step = 0.1;
        while (precision-- > 0) {
            double j = sqrt; // start from the integer part
            while (j * j <= n) {
                sqrt = j;
                j += step;
            }
            step /= 10;
        }
        return sqrt;
    }

    private static double BSPrecision(int n)
    {
        double start = 0;
        double end = n;
        double ans = 0;
        while ((end - start) > 0.000000001)
        {
            double mid = (start + end) / 2;
            double sqr = mid * mid;
            if (sqr <= n)
            {
                ans = mid;
                start = mid ;
            }
            else
                end = mid;
        }
        return ans;
    }
}
