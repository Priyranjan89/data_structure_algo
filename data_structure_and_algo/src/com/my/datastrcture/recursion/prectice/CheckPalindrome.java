package com.my.datastrcture.recursion.prectice;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "abbba";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str){
        int len = str.length();
        if (str.length() == 0 || str.length() == 1){
            return true;
        }

        if (str.charAt(0) != str.charAt(len-1)){
            return false;
        }
        return isPalindrome(str.substring(1, len-1));
    }
}
