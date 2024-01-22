package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class HourglassOfNumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for(int space = 1; space < i; space++){
                System.out.print(" ");
            }
            for (int j = i; j <= n; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        for (int i = n-1; i > 0; i--){
            for(int space = 1; space < i; space++){
                System.out.print(" ");
            }
            for (int j = i; j <= n; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
