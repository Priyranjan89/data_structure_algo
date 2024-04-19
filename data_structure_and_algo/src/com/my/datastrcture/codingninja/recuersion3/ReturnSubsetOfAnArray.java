package com.my.datastrcture.codingninja.recuersion3;

public class ReturnSubsetOfAnArray {
    public static void main(String[] args) {
        int input[] = {15, 20, 12};
        int output[][] = subsets(input);
        for (int i = 0; i < output.length; i++){
            for (int j = 0; j < output[i].length; j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] subsets(int input[]) {
        return subsetsHelper(input, 0);
    }

    public static int[][] subsetsHelper(int input[], int startIndex) {
        if (startIndex == input.length){
            int output[][] = new int[1][0];
            return  output;
        }
        int smallOutput[][] = subsetsHelper(input, startIndex+1);
        int output[][] = new int[smallOutput.length * 2][];
        int k = 0;
        for (int i = 0; i < smallOutput.length; i++){
            output[i] = new int[smallOutput[i].length];
            for (int j =0; j < smallOutput[i].length; j++){
                output[i][j] = smallOutput[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallOutput.length; i++){
            output[k] = new int[smallOutput[i].length+1];
            output[k][0] = input[startIndex];
            for (int j =0; j < smallOutput[i].length; j++){
                output[k][j+1] = smallOutput[i][j];
            }
            k++;
        }
        return output;
    }
}
