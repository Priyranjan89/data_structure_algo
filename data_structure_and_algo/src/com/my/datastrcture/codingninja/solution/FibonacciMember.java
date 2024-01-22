package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class FibonacciMember {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(checkMember(n));
    }

    public static boolean checkMember(int n){
        int a = 0;
        int b = 1;
        int c = 0;

        if (n == 1 || n == 0){
            return true;
        }
        for (int i = 1; i <= n; i++){
            c = a+b;
            if(c == n){
                return true;
            }
            a = b;
            b = c;
        }
        return false;
    }
}
