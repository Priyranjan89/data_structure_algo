package com.my.datastrcture.prectice;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        switch ( n ){
            case 1:
                System.out.println("First");
                break;
            case 2:
                System.out.println("Second");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Any number");
        }
    }
}
