package com.my.datastrcture.codingninja.timecomplexxity;

public class CheckAbUsingRecursion {
    public static void main(String[] args) {
        String str = "abbab";
        System.out.println(checkAB(str));
    }

    public static boolean checkAB(String input) {

        if (input.length() == 0) {
            return true;
        }

        if (input.charAt(0) == 'a') {
            if (input.substring(1).length() > 1 && input.substring(1, 3).equals("bb")) {
                return checkAB(input.substring(3));
            } else {
                return checkAB(input.substring(1));
            }
        }
        return false;
    }

    public static boolean helper(String input, int index){
        if (index >= input.length() || input.charAt(index) == '\0'){
            return true;
        }
        if (input.charAt(index) != 'a'){
            return false;
        }
        if (input.charAt(index + 1) != '\0' && input.charAt(index + 2) != '\0'){
            if (input.charAt(index + 1) == 'b' && input.charAt(index + 2) == 'b'){
                return helper(input, index + 3);
            }
        }
        return helper(input, index + 1);
    }
}
