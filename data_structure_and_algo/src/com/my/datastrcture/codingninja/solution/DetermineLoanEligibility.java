package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class DetermineLoanEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        double income = sc.nextDouble();
        boolean outstanding  = sc.nextBoolean();

        if (age < 18 || (outstanding) || income < 2000 ){
            System.out.println("You are not eligible for the loan.");
        } else {
            System.out.println("You are eligible for the loan.");
        }

    }
}
