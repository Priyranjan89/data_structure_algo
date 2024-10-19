package com.my.datastrcture.codingninja.recuersion3;

public class PrintAllCodesString {
    public static void main(String[] args) {
        String input = "1123";
        printAllPossibleCodes(input);
    }

    public static void printAllPossibleCodes(String input) {
        printCodes(input,"");
    }

    private static void printCodes(String input, String currentCode) {
        if (input.length() == 0){
            System.out.println(currentCode);
            return;
        }
        int firstDigit = input.charAt(0) - '0';
        if (firstDigit >= 1 && firstDigit <= 9){
            char firstDigitChar = (char) ('a' + firstDigit - 1);
            printCodes(input.substring(1), currentCode + firstDigitChar);
        }
        if (input.length() >= 2){
            int firstTwoDigit = Integer.parseInt(input.substring(0,2));
            if (firstTwoDigit >= 10 && firstTwoDigit <= 26){
                char firstTwoDigitChar = (char) ('a' + firstTwoDigit - 1);
                printCodes(input.substring(2), currentCode + firstTwoDigitChar);
            }
        }
    }


}
