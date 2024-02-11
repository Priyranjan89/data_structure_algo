package com.my.datastrcture.codingninja.recursion;

public class ReplaceCharacterRecursively {
    public static void main(String[] args) {
        String input = "abacd";
        char c1 = 'a';
        char c2 = 'x';
        System.out.println(replaceCharacter(input, c1, c2));
    }

    public static String replaceCharacter(String input, char c1, char c2) {

        if (input.length() == 0){
            return input;
        }
        String ans = replaceCharacter(input.substring(1), c1, c2);

        if (input.charAt(0) == c1){
            return c2 + ans;
        } else {
            return input.charAt(0) + ans;
        }
    }
}
