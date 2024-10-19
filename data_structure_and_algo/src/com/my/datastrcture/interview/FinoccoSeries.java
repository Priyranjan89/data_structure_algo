package com.my.datastrcture.interview;

public class FinoccoSeries {
    public static void main(String[] args) {
        int n = 10;
        fibanacco(n);
    }

    private static void fibanacco(int n){
        int a = 0;
        int b = 1;
        int c = a+b;

        System.out.print(a+" ");
        System.out.print(b+" ");

        for (int i = 0; i < n-2; i++){
            a = b;
            b = c ;
            System.out.print(c+" ");
            c = a+b;
            
        }
    }

}
