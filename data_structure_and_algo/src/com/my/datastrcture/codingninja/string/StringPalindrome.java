package com.my.datastrcture.codingninja.string;


public class StringPalindrome {
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(str+" is palindrome : "+isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
       /*
       boolean isFlag = false;
       String str2 = "";

       for (int i = str.length()-1; i >= 0; i--){
           str2 = str2+str.charAt(i);
       }

       if (str.equals(str2)){
           isFlag = true;
       }*/
        boolean isFlag = true;

        int l = 0;
        int r = str.length()-1;

        while (l < r){
            if (str.charAt(l) != str.charAt(r)){
                isFlag = false;
            }
            l++;
            r--;
        }

       return isFlag;
    }
}
