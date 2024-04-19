package com.my.datastrcture.codingninja.recuersion3;

import java.util.Scanner;

public class ReturnKeypadOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String output[] = keypad(n);
        for (String str : output){
            System.out.println(str);
        }
    }

    public static String[] keypad(int n){
        if (n == 0){
            String output[] = {""};
            return output;
        }

        int num = n%10;
        String smallOutput[] = keypad(n/10);
        String mapping = getMapping(num);
        String output[] = new String[smallOutput.length * mapping.length()];

        int k = 0;
        for (int i = 0; i <smallOutput.length; i++){
            String small = smallOutput[i];
            for (int j = 0; j < mapping.length(); j++){
                output[k++] = small + mapping.charAt(j);;
            }
        }
        return output;
    }

    private static String getMapping(int index){
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return arr[index];
    }
}
