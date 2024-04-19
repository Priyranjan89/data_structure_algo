package com.my.datastrcture.recursion.prectice;

import java.util.Scanner;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter string for reversal : ");
        String str = sc.nextLine();

        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        return reverseSting(str, 0);
    }

    private static String reverseSting(String str, int index) {
        if (index == str.length()){
            return "";
        }
        String ans = reverseSting(str, index+1);
        ans = ans+str.charAt(index);
        return ans;
    }

}
