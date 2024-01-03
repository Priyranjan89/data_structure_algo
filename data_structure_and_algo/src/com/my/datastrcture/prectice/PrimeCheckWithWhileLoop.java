package com.my.datastrcture.prectice;

import java.util.Scanner;

public class PrimeCheckWithWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n");
        int n = scanner.nextInt();

        //int i =2;
        boolean isPrime = isPrimeNumber(n);
        if (isPrime){
            System.out.println(n+" is Prime");
        } else {
            System.out.println(n+" is not Prime");
        }
    }

    private static boolean isPrimeNumber(int n) {
        boolean isPrime = true;
       /* while(i < n){
            if (n%i == 0){
                isPrime = false;
                break;
            } else  {
                isPrime = true;
            }
          i++;
        }*/

        for (int i = 2; i < n; i++){
            if (n %i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
