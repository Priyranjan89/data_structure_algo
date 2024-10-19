package com.my.datastrcture.codingninja.recuersion3;

public class ReturnAllCodesString {
    public static void main(String[] args) {
        String input = "1123";
        String output[] = getCode(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public static String[] getCode(String input) {
        if (input.length() == 0) {
            String ans[] = {""};
            return ans;
        }
        int firstDigit = input.charAt(0) - '0';
        String smallAns1[] = getCode(input.substring(1));
        String smallAns2[] = new String[0];

        int firstTwoDigit =0;
        if (input.length() >= 2){
            firstTwoDigit = (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0') ;
            if (firstTwoDigit >= 10 && firstTwoDigit <= 26){
                smallAns2 = getCode(input.substring(2));
            }
        }

        String output[] = new String[smallAns1.length + smallAns2.length];
        int k = 0;
        for (String str : smallAns1) {
            char firsDigitChar = getChar(firstDigit);
            output[k++] = firsDigitChar + str;
        }
        for (String str : smallAns2) {
            char firsTwoDigitChar = getChar(firstTwoDigit);
            output[k++] = firsTwoDigitChar + str;
        }
        return output;
    }

    private static char getChar(int digit){
        return (char)('a' + digit-1);
    }
}
