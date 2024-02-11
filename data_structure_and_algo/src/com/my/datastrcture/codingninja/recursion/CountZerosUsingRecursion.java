package com.my.datastrcture.codingninja.recursion;

import java.util.Scanner;

public class CountZerosUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countZerosRec(n));
    }

    public static int countZerosRec(int input){
        if (input == 0 ){
            return 1;
        }

        if (input >= 1 && input <= 9){
            return 0;
        }

       /* if (input <= 9){
            if (input == 0){
                return 1;
            } else {
                return 0;
            }
        }*/

        int count = countZerosRec(input/10);
        if (input % 10 == 0){
            count++;
        }
        return count;
    }
}
