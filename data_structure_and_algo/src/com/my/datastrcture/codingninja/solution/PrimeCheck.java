package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        printPrime(num);
    }

    private static void printPrime(int num) {
        for (int n = 2; n <= num; n++){
            boolean isPrime = isPrimeNumber(n);
            if (isPrime) {
                System.out.print(n+" ");
            }
        }
    }

    private static boolean isPrimeNumber(int n) {
        boolean isPrime = true;
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
