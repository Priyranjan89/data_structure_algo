package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern6 {

    public static void main(String[] args) {
        /*
         *    *
         *    * *
         *    * * *
         *    * * * *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();

        int i = 1;
        while (i <= n){
            int j = 1;
            while (j <= i){
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
