package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class SumOfNNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter n value: ");
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}
