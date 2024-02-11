package com.my.datastrcture.codingninja.oops;

import java.util.Scanner;

public class MultiplyNumbers {
    // Main driver method
    public static void main(String[] args)
    {

        // Take input using Scanner and print the output .
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Helper helper = new Helper();
        System.out.println(helper.multiplication(a,b));
        System.out.println(helper.multiplication(a,b,c));
    }
}
