package com.my.datastrcture.prectice;

import java.util.Scanner;

public class NCRWithFactorialTest {
    public static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++){
            fact = fact*i;
        }
        return fact;
    }

    public static int nCr(int n,  int r){
        int num = factorial(n);
        int deno = factorial(r) * factorial(n-r);
        return num/deno;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();
        System.out.println("Please enter value of r");
        int r = sc.nextInt();

        int result = nCr(n, r);
        System.out.println("Answer of nCr : "+result);
    }

}
