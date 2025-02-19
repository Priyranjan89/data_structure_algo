package com.my.datastrcture.codingninja.recursion.hard;

import java.util.Scanner;

public class PrintKeypadStringInPhone {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        printKeypad(n);
    }

    public static void printKeypad(int input){
        printKeypad(input,"");}

    public static void printKeypad(int input,String output){
        if (input == 0) {
            System.out.println(output);
            return;
        }
        int rem = input % 10;

        String str = keyMapping(rem);
        char helperArray[] = str.toCharArray();

        printKeypad(input / 10, helperArray[0] + output);
        printKeypad(input / 10, helperArray[1] + output);
        printKeypad(input / 10, helperArray[2] + output);

        if (helperArray.length == 4) {
            printKeypad(input / 10, helperArray[3] + output);
        }
    }
    private static String keyMapping(int newNum){
        String str[] =  {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        return str[newNum];
    }

}
