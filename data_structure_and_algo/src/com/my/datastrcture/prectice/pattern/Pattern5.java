package com.my.datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern5 {

    public static void main(String[] args) {
        /*
         *    1 2 3
         *    4 5 6
         *    7 8 9
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();

        int i = 0;
        int count= 1;
        while (i < n){
            int j = 0;
            while (j < n){
                System.out.print(count+" ");
                count++;
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
