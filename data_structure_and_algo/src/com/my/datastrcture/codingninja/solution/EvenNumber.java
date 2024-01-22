package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        /*for (int i = 1; i <= num; i++){
            if (i % 2 == 0 ){
                count++;
                if (count <= 4){
                    System.out.println(i);
                } else {
                    break;
                }
            }
        }*/
        for (int i = 1, j = 4; i <= num && j > 0; i++){
            if (i % 2 == 0){
                System.out.println(i);
                j--;
            }
        }
    }
}
