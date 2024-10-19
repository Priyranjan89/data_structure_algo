package com.my.datastrcture.codingninja.string;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        String s = "today is sunday";
        System.out.println(s);
        System.out.println(reverseWord(s));
        System.out.println(reverseWordOptimize(s));
    }

    public static String reverseWord(String str) {
        String revWord = "";
        String arr[] = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String str1 = arr[i];

            for (int j = str1.length() - 1; j >= 0; j--) {
                revWord = revWord + str1.charAt(j);
            }

            if (i != arr.length - 1) {
                revWord += " ";
            }
        }

        return revWord;
    }

    public static String reverseWordOptimize(String str) {
        String revWord = "";
        String small = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' '){
                small = str.charAt(i) + small;
            } else {
                revWord = revWord + small + " ";
                small = "";
            }
            if (i == str.length()-1){
                revWord = revWord + small;
            }
        }
        return revWord;
    }

}
