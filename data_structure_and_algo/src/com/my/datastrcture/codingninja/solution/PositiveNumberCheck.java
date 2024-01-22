package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class PositiveNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num >= 0){
            System.out.println("It is Positive Number");
        } else {
            System.out.println("It is Negative Number");
        }
    }
}
