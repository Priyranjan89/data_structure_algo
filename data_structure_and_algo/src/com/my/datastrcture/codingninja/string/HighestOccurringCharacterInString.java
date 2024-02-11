package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class HighestOccurringCharacterInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the String : ");
        String str = sc.nextLine();
        System.out.println("Highest Occurring character in String : "+highestOccurringChar(str));
    }

    public static char highestOccurringChar(String str) {
        char ch = '\0';
        int max = 0;

        char arr[] = new char[256];
        for (int i = 0; i<str.length();i++){
            arr[str.charAt(i)] += 1;
            max = Math.max(max, arr[str.charAt(i)]);
        }

        for (int i = 0; i<str.length();i++){
            if (arr[str.charAt(i)] == max){
                ch = str.charAt(i);
                break;
            }
        }

        return ch;
    }
}
