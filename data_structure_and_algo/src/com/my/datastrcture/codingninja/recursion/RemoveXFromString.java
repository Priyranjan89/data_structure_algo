package com.my.datastrcture.codingninja.recursion;

public class RemoveXFromString {
    public static void main(String[] args) {
        String input = "axbxcdxefx";
        System.out.println(removeX(input));
    }

    public static String removeX(String input){

        if (input.length() == 0){
            return input;
        }

        String ans = removeX(input.substring(1));
        if (input.charAt(0) != 'x'){
            ans = input.charAt(0) + ans;
        }

        return ans;
    }
}
