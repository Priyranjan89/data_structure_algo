package com.my.datastrcture.prectice.recursion;

public class ReturnSubSequencesOfString {
    public static void main(String[] args) {
        String[] output = subsequence("abc");
        for (String str : output){
            System.out.println(str);
        }
    }

    public static String[] subsequence(String input){
        if (input.length() == 0){
            String[] output = {""};
            return output;
        }

        String[] smallOutput = subsequence(input.substring(1));
        String[] finalOutput = new String[2*smallOutput.length];

        int k = 0;
        for (int i = 0; i < smallOutput.length; i++){
            finalOutput[k++] = smallOutput[i];
            finalOutput[k++] = input.charAt(0) + smallOutput[i];
        }
        return finalOutput;
    }
}
