package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class FindThePowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int ans = 1;

        if ((x > 8 || x < 0) || (n > 9 || n < 0)){
            return;
        }

        if (n == 0){
            System.out.println(1);
            return;
        }
        for (int i = 1; i <=n; i++){
            ans *= x;
        }
        System.out.println(ans);
    }
}
