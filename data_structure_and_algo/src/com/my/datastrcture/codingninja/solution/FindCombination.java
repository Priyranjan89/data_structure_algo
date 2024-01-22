package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class FindCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        if (n < 0 || r < 0 || n < r){
            return;
        }

        // nCr = n!/(r! *(n-r)!);
        int factN = getFactorial(n);
        int factR = getFactorial(r);
        int factNR = getFactorial(n-r);

        int nCr = factN/(factR * factNR);

        System.out.println(nCr);

    }

    public static int getFactorial(int num){
        int fact = 1;

        for (int i =1; i<= num; i++){
            fact *= i;
        }
        return fact;
    }
}
