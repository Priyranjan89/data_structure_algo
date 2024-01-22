package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class MultiplyTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F1 = sc.nextInt();
        int F2 = sc.nextInt();
        long result = (long)F1*(long)F2;
        System.out.println(result);
    }
}
