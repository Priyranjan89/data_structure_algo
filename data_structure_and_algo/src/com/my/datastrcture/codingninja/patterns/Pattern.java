package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*for (int i = 0; i < n; i++){
            for (int j =0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }*/

       /* for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((n-j+1)+" ");
            }
            System.out.println();
        }*/

        /*System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int k = n-i; k > 0; k--){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        int count = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
