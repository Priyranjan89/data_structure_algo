package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class CompositeNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print_composite(n);
    }

    public static void print_composite(int n)
    {
        for (int i = 2; i <= n; i++){
            boolean isCompos = isComposite(i);
            if (isCompos){
                System.out.println(i);
            }
        }
    }

    public static boolean isComposite(int n) {
        boolean isComposite = false;

        for(int i = 2; i < n; i++){
            if(n % i == 0){
                isComposite = true;
            }
        }
        return isComposite;
    }
}
