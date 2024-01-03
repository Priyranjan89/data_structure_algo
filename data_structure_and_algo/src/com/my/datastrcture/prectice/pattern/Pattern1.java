package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        /*
        *    * * *
        *    * * *
        *    * * *
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the value of n");
        int n = scanner.nextInt();
        System.out.println();

        int i =0;
        while (i < n){
            int j = 0;
            while (j < n){
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
