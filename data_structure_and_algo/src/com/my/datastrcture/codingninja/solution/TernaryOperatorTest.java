package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class TernaryOperatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a value: ");
        int a = sc.nextInt();
        System.out.println("Please enter b value: ");
        int b = sc.nextInt();
        System.out.println("Please enter c value: ");
        int c = sc.nextInt();

        int greatest =  a > b ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("The Greatest value is "+greatest);
    }
}
