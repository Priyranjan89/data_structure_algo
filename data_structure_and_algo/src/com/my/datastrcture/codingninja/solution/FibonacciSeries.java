package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;

        System.out.print(a+" ");
        System.out.print(b+" ");

       /* while (count > 0){
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
            count--;
        }*/

        for (int i = 1; i < n-1; i++){
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
    }
}
