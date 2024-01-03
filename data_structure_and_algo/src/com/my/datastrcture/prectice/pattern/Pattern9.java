package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        /*
         *    1
         *    2 3
         *    3 4 5
         *    4 5 6 7
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = 1;
            int val = row;
            while (col <= row){
                System.out.print(val +" ");
                col++;
                val++;
            }
            row++;
            System.out.println();
        }
    }
}
