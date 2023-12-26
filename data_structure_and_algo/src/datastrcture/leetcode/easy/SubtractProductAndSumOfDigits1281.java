package datastrcture.leetcode.easy;

import java.util.Scanner;

/*
* Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21
 */
public class SubtractProductAndSumOfDigits1281 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        int result = getResult(n);
        System.out.println("Result :"+result);
    }

    private static int getResult(int n) {
        int prod = 1;
        int sum = 0;

        while (n >= 1){
            int rem = n %10;
            n = n /10;
            prod *= rem;
            sum += rem;
        }
        return prod-sum;
    }
}
