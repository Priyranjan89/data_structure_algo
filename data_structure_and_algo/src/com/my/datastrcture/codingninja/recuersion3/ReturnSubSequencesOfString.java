package com.my.datastrcture.codingninja.recuersion3;

public class ReturnSubSequencesOfString {
    public static void main(String[] args) {
        String input = "abc";
        String[] output = subsequence(input);
        for (String str : output){
            System.out.println(str);
        }
    }

    public static String[] subsequence(String input){
        if (input.length() == 0){
            String output[] = {""};
            return output;
        }

        String smallOutput[] = subsequence(input.substring(1));
        String output[] = new String[2 * smallOutput.length];

        int k = 0;
        for (int i = 0; i < smallOutput.length; i++){
            output[k++] = smallOutput[i];
        }

        for (int i = 0; i < smallOutput.length; i++){
            output[k++] = input.charAt(0)+ smallOutput[i];
        }
        return output;
    }
}
