package com.my.datastrcture.codingninja.recuersion3.test;

public class ReturnSubSequencesOfString1 {
    public static void main(String[] args) {
        String input = "abc";
        String[] output = subsequence(input);
        for (String str : output){
            System.out.println(str);
        }
    }

    public static String[] subsequence(String input){
        if (input.isEmpty()){
            String ans[] = {""};
            return ans;
        }

        String smallAns[] = subsequence(input.substring(1));
        String finalAns[] = new String[2 * smallAns.length];

        int k = 0;
        for (int i = 0; i < smallAns.length; i++){
            finalAns[k++] = smallAns[i];
            finalAns[k++] = input.charAt(0)+smallAns[i];
        }
        /*for (int i = 0; i < smallAns.length; i++){
            finalAns[k++] = smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++){
            finalAns[k++] = input.charAt(0)+smallAns[i];
        }*/
        return finalAns;
    }
}
