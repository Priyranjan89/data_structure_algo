package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(palindromeNumber(n));
    }
    public static boolean palindromeNumber(int n){
        boolean isPalindrome = false;
        int temp = n;
        int num = 0;

        while (temp != 0){
            int rem = temp % 10;
            num = (num * 10) + rem;
            temp = temp / 10;
        }

        if (n == num){
            isPalindrome = true;
        }

        return isPalindrome;
    }
}
