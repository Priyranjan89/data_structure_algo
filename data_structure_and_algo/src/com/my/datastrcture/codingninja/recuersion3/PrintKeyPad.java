package com.my.datastrcture.codingninja.recuersion3;

import java.util.Scanner;

public class PrintKeyPad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printKeypad(n);
    }

    public static void printKeypad(int input){
        printKeypadHelper(input,"");
    }
    private static void printKeypadHelper(int input, String output){
        if (input == 0){
            System.out.println(output);
            return;
        }
        String mapping = getMapping(input%10);
        printKeypadHelper(input/10, mapping.charAt(0)+output);
        printKeypadHelper(input/10, mapping.charAt(1)+output);
        printKeypadHelper(input/10, mapping.charAt(2)+output);
        if (mapping.length() == 4){
            printKeypadHelper(input/10, mapping.charAt(3)+output);
        }
    }
    /*private static void printKeypadHelper(int input, String output){
        if (input == 0){
            System.out.println(output);
            return;
        }
        String mapping = getMapping(input%10);
        for (int i = 0; i < mapping.length(); i++){
            printKeypadHelper(input/10, mapping.charAt(i) + output);
        }
    }*/

    private static String getMapping(int index){
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return arr[index];
    }

}
