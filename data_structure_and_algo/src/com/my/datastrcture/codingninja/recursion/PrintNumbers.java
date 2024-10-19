package com.my.datastrcture.codingninja.recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 10;
        print(n);
        System.out.println();
        System.out.println(fib(7));
    }

    public static void print(int n){
        if (n == 0){
            return;
        }
        print(n-1);
        System.out.print(n+" ");
    }

    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+ fib(n-2);
    }
}
