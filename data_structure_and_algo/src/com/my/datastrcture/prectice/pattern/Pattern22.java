package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern22 {

    public static void main(String[] args) {
        /*
         *    1 2 3 4 5 5 4 3 2 1
         *    1 2 3 4 * * 4 3 2 1
         *    1 2 3 * * * * 3 2 1
         *    1 2 * * * * * * 2 1
         *    1 * * * * * * * * 1
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = n-row;
            int count = 1;
            while (col>=0){
                System.out.print(count+" ");
                col--;
                count++;
            }

            int star = (row-1)*2;
            while (star >= 1){
                System.out.print("* ");
                star--;
            }
            int num = n-row+1;
            int col2 = n-row;
            while(col2>=0){
                System.out.print(num+" ");
                num--;
                col2--;
            }
            System.out.println();
            row++;
        }

    }
}
