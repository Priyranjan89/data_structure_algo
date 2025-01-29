package com.my.datastrcture.prectice.recursion;


public class PrintAllStringCodes {
    public static void main(String[] args) {
        String input = "1123";
        printAllPossibleCodes(input);
    }

    public static void printAllPossibleCodes(String input) {
        getCodeHelper(input, "");
    }

    private static void getCodeHelper(String input, String currentCode) {
        if (input.length() == 0){
            System.out.println(currentCode);
            return;
        }
        int firstDigit = input.charAt(0) - '0';
        if (firstDigit >= 1 && firstDigit <= 9){
            char firstDigitChar = (char) ('a' + firstDigit -1);
            getCodeHelper(input.substring(1), currentCode + firstDigitChar);
        }

        if (firstDigit == 0){
            getCodeHelper(input.substring(1), currentCode);
        }

        if (input.length() >= 2){
            int twoDigit = Integer.parseInt(input.substring(0, 2));
            if (twoDigit >= 10 && twoDigit <= 26){
                char twoDigitChar = (char) ('a' + twoDigit - 1);
                getCodeHelper(input.substring(2), currentCode + twoDigitChar);
            }
        }
    }
}
