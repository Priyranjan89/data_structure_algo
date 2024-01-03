package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        /*
         *    A A A
         *    B B B
         *    C C C
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();
        /* char ch= 'A';

        int i = 1;
        while (i <= n){
            int j = 1;
            while (j <= n){
                System.out.print(ch+" ");
                j++;
            }
            System.out.println();
            i++;
            ch++;

        }*/

        int row = 1;
        while (row <= n){
            int col = 1;
            while (col <= n){
                char ch = (char) ('A'+row-1);
                System.out.print(ch+" ");
                col++;
            }
            System.out.println();
            row++;

        }
    }
}
