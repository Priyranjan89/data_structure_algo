package com.my.datastrcture.codingninja.string;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CountNumberOfWordInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the Sentence : ");
        String str = sc.nextLine();
        System.out.println("Total number of word in sentence : "+countWord(str));

    }

    public static int countWord(String str){
       /*int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }*/

        String strArr[] = str.split(" ");
        return strArr.length;
    }
}
