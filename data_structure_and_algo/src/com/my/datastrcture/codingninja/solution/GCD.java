package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(findGCD(x, y));
    }

    public static int findGCD(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++){
            if ((a % i == 0) && (b % i == 0)){
                gcd = i;
            }
        }
        return gcd;
    }
}
