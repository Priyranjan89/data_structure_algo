package com.my.datastrcture.codingninja.recursion;

public class CheckPalindromeUsingRecursive {
    public static void main(String[] args) {
        String str = "abbba";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        if (len == 0 || len == 1){
            return true;
        }

        if (str.charAt(0) != str.charAt(len-1)){
            return false;
        }

        return isPalindrome(str.substring(1,len-1));
    }
}
