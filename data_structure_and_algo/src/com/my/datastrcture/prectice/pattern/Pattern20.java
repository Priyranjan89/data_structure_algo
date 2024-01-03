package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern20 {
    public static void main(String[] args) {
        /*
         *  * * * *
         *    * * *
         *      * *
         *        *
         *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int space = row-1;
            while (space>=1){
                System.out.print("  ");
                space--;
            }

            int col = n-row;
            while (col>=0){
                System.out.print(" "+row);
                col--;
            }

            System.out.println();
            row++;
        }

    }
}
