package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*for (int i = 1; i <= n; i++){
            for (int j =1; j <= n; j++){
                char ch = (char) ('A'+j -1);
                System.out.print(ch);
            }
            System.out.println();
        }*/

      /*  for (int i = 1; i <= n; i++){
            for (int j =1; j <= n; j++){
                char ch = (char) ('A'+j + i -2);
                System.out.print(ch);
            }
            System.out.println();
        }*/

        /*for (int i = 1; i <= n; i++){
            char ch = (char)('A'+n-i);
            for (int j =1; j <= i; j++){
                System.out.print(ch);
                ch = (char)(ch+1);
            }
            System.out.println();
        }*/

        /*for (int i = n; i > 0; i--){
            for (int j =1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }*/

       /* for (int i = 1; i <= n; i++) {
            for (int k = n-i; k > 0; k--){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        for (int i = 1; i <= n; i++){
            char ch = (char)('A'+n-1);
            for (int j =1; j <= i; j++){
                System.out.print((char)(ch - j + 1));
            }
            System.out.println();
        }
    }
}
