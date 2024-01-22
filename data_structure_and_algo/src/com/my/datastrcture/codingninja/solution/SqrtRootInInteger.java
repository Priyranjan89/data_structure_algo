package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class SqrtRootInInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ans = 0;

        for (int i = 2; i < num; i++){
            int sqrt = i * i;
            if (sqrt > num){
                break;
            }
            ans = i;
        }
        System.out.println(ans);
    }
}
