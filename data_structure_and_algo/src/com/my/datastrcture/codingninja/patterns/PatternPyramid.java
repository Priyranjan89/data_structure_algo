package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class PatternPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*for (int i = 1; i <=n; i++){
            for (int space = n-i; space > 0; space-- ){
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(" *");
            }
            for (int k = 1; k < i; k++){
                System.out.print(" *");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <=n; i++){
            for (int space = 1; space <= n-i; space++ ){
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i -1; j++){
                System.out.print(" *");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <=n; i++){
            for (int space = 1; space <= n-i; space++ ){
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i -1; j++){
                System.out.print(" "+j);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <=n; i++){
            for (int space = n-i; space > 0; space-- ){
                System.out.print(" ");
            }
            int count = i;
            for (int j = 1; j <= i; j++){
                System.out.print(count);
                count++;
            }
            count--;
            for (int k = 1; k < i; k++){
                count--;
                System.out.print(count);
            }
            System.out.println();
        }*/

        for (int i = 1; i <=n; i++){
            for (int space = n-i; space > 0; space-- ){
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++){
                System.out.print(j);

            }
            int count = i;
            for (int k = 1; k < i; k++){
                count--;
                System.out.print(count);
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        for (int i = 1; i <=n; i++){
            for (int space = 1; space <= n-i; space++ ){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i -1; j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
