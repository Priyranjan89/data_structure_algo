package com.my.datastrcture.codingninja.recuersion3;

public class PrintSubsetSumToK {
    public static void main(String[] args) {
        int input[] = {5,12,3,17,1,18,15,3,17};
        int k = 6;
        printSubsetsSumTok(input, k);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTokHelper(input, k, new int[0],0);
    }

    public static void printSubsetsSumTokHelper(int input[], int k, int output[], int startIndex) {
        if (startIndex == input.length){
            if (k == 0){
                for (int i = 0; i < output.length; i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
                return;
            } else
                return;
        }
        int newOutput[] = new int[output.length+1];
        int i;
        for (i = 0; i<output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = input[startIndex];
        printSubsetsSumTokHelper(input, k , output, startIndex+1);
        printSubsetsSumTokHelper(input, k - input[startIndex], newOutput, startIndex+1);

    }
}
