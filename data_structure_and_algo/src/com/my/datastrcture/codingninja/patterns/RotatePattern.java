package com.my.datastrcture.codingninja.patterns;

import java.util.Scanner;

public class RotatePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            int count = i;
            for (int j = 1; j <=n; j++){
                System.out.print(count+" ");
                if (count == n){
                    count = 1;
                } else {
                    count++;
                }
            }
            System.out.println();
        }
    }
}
