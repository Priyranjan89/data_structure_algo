package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern21 {

    public static void main(String[] args) {
        /*
         *        1
         *      1 2 1
         *    1 2 3 2 1
         *  1 2 3 4 3 2 1
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int space = n-row;
            while (space>=1){
                System.out.print("  ");
                space--;
            }
            int col = 1;
            while (col <= row){
                System.out.print(col+" ");
                col++;
            }

            int right = row-1;
            while (right >= 1){
                System.out.print(right+" ");
                right--;
            }
            System.out.println();
            row++;
        }

    }
}
