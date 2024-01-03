package com.my.datastrcture.prectice;

import java.util.Scanner;

public class FindSumOfAllEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of n");

        int n  = scanner.nextInt();
        int i = 2;
        int sum = 0;

        System.out.println("Print Even number");
        while (i <= n){
            if (i%2 == 0){
                System.out.print(i +" ");
                sum = sum+i;
            }
            i++;
        }
        System.out.println();
        System.out.println("Sum of Even Number = "+sum);
    }
}
