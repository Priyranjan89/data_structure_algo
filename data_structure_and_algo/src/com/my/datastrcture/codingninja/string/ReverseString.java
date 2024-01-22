package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter string for reversal : ");
        String str = sc.nextLine();

        System.out.println("Please find reverse "+str+" is "+stringReverse(str.toCharArray()));
    }

    public static String reverseString(String str){
        String revStr = "";
        /*for (int i = str.length()-1; i >= 0; i--){
            revStr = revStr+str.charAt(i);
        }*/

        for (int i = 0; i < str.length(); i++){
            revStr = str.charAt(i)+revStr;
        }
        return revStr;
    }

    public static String stringReverse(char[] arr) {
        String revStr = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            revStr = revStr + arr[i];
        }
        return revStr;
    }
}
