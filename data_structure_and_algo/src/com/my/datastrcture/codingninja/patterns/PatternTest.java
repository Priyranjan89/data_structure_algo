package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class PatternTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++){
            for (int k = n-i; k > 0; k-- ){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(" "+i);
            }

            System.out.println();
        }


        /*for (int i = 1; i <=n; i++){
            for (int k = 1; k < i; k++ ){
                System.out.print(" ");
            }
            for (int j = n - i + 1; j > 0; j--){
                System.out.print(" *");
            }
            System.out.println();
        }*/
    }
}
