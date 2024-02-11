package com.my.datastrcture.codingninja.recursion;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String input = "xxxyyyzwwzzz";
        System.out.println(removeConsecutiveDuplicates(input));
    }

    public static String removeConsecutiveDuplicates(String s) {

        if (s.length() <= 1){
            return s;
        }
        String str = removeConsecutiveDuplicates(s.substring(1));

        if (s.charAt(0) != s.charAt(1)){
            str = s.charAt(0) + str;
        }

        return str;
    }
}
