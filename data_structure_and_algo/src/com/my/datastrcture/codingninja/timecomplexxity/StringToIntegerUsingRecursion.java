package com.my.datastrcture.codingninja.timecomplexxity;

public class StringToIntegerUsingRecursion {
    public static void main(String[] args) {
        String str = "12567";
        System.out.println(convertStringToInt(str));
    }

    public static int convertStringToInt(String input){
        return convertStringToInt(input, input.length()-1);
    }

    public static int convertStringToInt(String input, int startIndex){
        if (startIndex == 0){
            char ch = input.charAt(startIndex);
            int num = ch - '0';
            return num;
        }
        char ch = input.charAt(startIndex);
        int num = ch - '0';

        int ans = convertStringToInt(input, startIndex-1);
        return (ans * 10) + num;
    }
}
