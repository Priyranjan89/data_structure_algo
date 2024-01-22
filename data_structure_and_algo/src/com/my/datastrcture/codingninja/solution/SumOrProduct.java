package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class SumOrProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int choice = sc.nextInt();

        int ans;

        if (num > 12 || num < 1){
            return;
        }

        if (choice == 1){
            ans = 0;
            for (int i = 1; i <= num; i++){
                ans += i;
            }
            System.out.println(ans);
        } else if (choice == 2) {
            ans = 1;
            for (int i = 1; i <= num; i++){
                ans *= i;
            }
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
