package com.my.datastrcture.interview;

public class NonRepetibleCharInString {
    public static char[] getChar(String str){
        char count[] = new char[256];
        for (int i = 0; i<str.length(); i++){
            count[str.charAt(i)]++;
        }

        return count;
    }

    public static void main(String[] args) {

        String str = "ABCDACBEF";
        char count[] = getChar(str);

        for (int i = 0; i<str.length();i++){

            if (count[str.charAt(i)] == 1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
