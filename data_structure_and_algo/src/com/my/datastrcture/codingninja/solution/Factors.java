package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        boolean isFactors = false;

        for(int i = 2; i < num; i++){
            if(num % i == 0){
                System.out.print(i+" ");
                isFactors = true;
            }
        }
        if(!isFactors){
            System.out.println(-1);
        }
    }
}
