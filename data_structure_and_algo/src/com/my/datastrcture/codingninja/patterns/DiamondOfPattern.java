package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class DiamondOfPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++){
           if (i == 1 || i % 2 != 0){
               for (int space = 1; space <= ((n-i)/2); space++ ){
                   System.out.print(" ");
               }
               for (int j = 1; j <= i; j++){
                   System.out.print("*");
               }
               System.out.println();
           }
        }

        for (int i = n-1; i > 0; i--){
            if (i == 1 || i % 2 != 0){
                for (int space = 1; space <= ((n-i)/2); space++ ){
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
