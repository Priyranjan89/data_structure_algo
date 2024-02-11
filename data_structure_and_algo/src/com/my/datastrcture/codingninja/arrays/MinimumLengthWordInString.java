package com.my.datastrcture.codingninja.arrays;

public class MinimumLengthWordInString {
    public static void main(String[] args) {
        String str = "abc de ghihjk a uvw h j";
        System.out.println("Minimum Length of word in string : "+minLengthWord(str));
    }

    public static String minLengthWord(String input){
        String ans = "";
        int len = Integer.MAX_VALUE;
        String str[] = input.split(" ");

        for (int i = 0; i < str.length; i++){
            if (str[i].length() < len){
                ans = str[i];
                len = str[i].length();
            }
        }
        return ans;
    }
}
