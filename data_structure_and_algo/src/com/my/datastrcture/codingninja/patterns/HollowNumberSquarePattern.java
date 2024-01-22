package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class HollowNumberSquarePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int count = 1;
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print(count);
                    count++;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
