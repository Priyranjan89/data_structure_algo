package com.my.datastrcture.prectice;

import java.util.Scanner;

public class TotalAmountInNoOfNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of a");
        int amount = sc.nextInt();



        switch ( 1 ){
            case 1:
                int note100 = amount/100;;
                amount = amount%100;
                if (note100 !=0){
                    System.out.println("Number of 100 note : "+note100);
                }
            case 2:
                int note50 = amount/50;
                amount = amount%50;
                if (note50 !=0){
                    System.out.println("Number of 50 note : "+note50);
                }
            case 3:
                int note20 = amount/20;
                amount = amount%20;
                if (note20 != 0){
                    System.out.println("Number of 20 note : "+note20);
                }
            case 4:
                int note10 = amount/10;
                amount = amount%10;
                if (note10 != 0){
                    System.out.println("Number of 10 note : "+note10);
                }
            case 5:
                int note1 = amount / 1;
                if (note1 != 0){
                    System.out.println("Number of 1 note : "+note1);
                }
            default:
                break;

        }

    }
}
