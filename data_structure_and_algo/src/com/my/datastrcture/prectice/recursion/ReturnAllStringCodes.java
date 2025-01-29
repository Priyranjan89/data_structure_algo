package com.my.datastrcture.prectice.recursion;

import java.util.ArrayList;

public class ReturnAllStringCodes {
    public static void main(String[] args) {
        String input = "1123";
        String ans[] = getCode(input);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static  String[] getCode(String input){
        ArrayList<String> codes = new ArrayList<>();
        getCodeHelper(input, "", codes);
        return codes.toArray(new String[0]);
    }

    private static  void getCodeHelper(String input, String currentCode, ArrayList<String> codes){
        if (input.length() == 0){
            codes.add(currentCode);
            return;
        }

        int firstDigit = input.charAt(0) - '0';
        if (firstDigit >= 1 && firstDigit <= 9){
            char firstDigitChar = (char) ('a' + firstDigit -1);
            getCodeHelper(input.substring(1), currentCode + firstDigitChar, codes);
        }

        if (firstDigit == 0){
            getCodeHelper(input.substring(1), currentCode, codes);
        }

        if (input.length() >= 2){
            int twoDigit = Integer.parseInt(input.substring(0, 2));
            if (twoDigit >= 10 && twoDigit <= 26){
                char twoDigitChar = (char) ('a' + twoDigit - 1);
                getCodeHelper(input.substring(2), currentCode + twoDigitChar, codes);
            }
        }
    }
}
