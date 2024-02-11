package com.my.datastrcture.codingninja.recursion;

public class ReplacePiInString {
    public static void main(String[] args) {
        System.out.println(replacePi("apiapipipiip"));
        System.out.println(replacePi("apsiaip"));
    }

    private static String replacePi(String str) {
        if (str.length() <= 1){
            return str;
        }

        if (str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            String ans = replacePi(str.substring(2));
            return "3.14" + ans;
        } else {
            return str.charAt(0) + replacePi(str.substring(1));
        }
    }
}
