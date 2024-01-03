package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        /*
         *    A B C
         *    B C D
         *    C D E
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = 1;
            while (col <= n){
                //char ch = (char) ('A-1+(row+col)-1);
                char ch = (char) ('A'+(row+col)-2);
                System.out.print(ch+" ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
