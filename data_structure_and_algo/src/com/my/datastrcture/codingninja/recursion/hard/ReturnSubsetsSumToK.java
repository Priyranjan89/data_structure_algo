package com.my.datastrcture.codingninja.recursion.hard;

public class ReturnSubsetsSumToK {
    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;

        int ans[][] = subsetsSumK(arr, k);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] subsetsSumK(int input[], int k) {
        return subsetsSumKHelper(input, k, 0);
    }
    private static int[][] subsetsSumKHelper(int input[], int k, int startIndex) {

        //Base case - If startIndex == input.length
        //We can have two cases in the base condition
        //1. If k==0 - This means the desired sum has been achieved by including the last element of the input array
        //2. If k!=0 - Desired sum has not been achieved even when last element is included
        if (startIndex == input.length) {
            int arr[][];
            if (k == 0) {
                arr = new int[1][0];
            } else {
                arr = new int[0][0];
            }
            return arr;
        }

        //Considering recursive hypothesis where we have the subsets of two cases
        //1. Subsets containing current input[startIndex] element - smallOutput1
        //2. Subsets not containing current input[startIndex] element - smallOutput2

        int smallOutput1[][] = subsetsSumKHelper(input, k, startIndex + 1);
        int smallOutput2[][] = subsetsSumKHelper(input, k - input[startIndex], startIndex + 1);

        //Now, we simply need to combine smallOutput1 and smallOutput2 and return to the calling function
        //When copying smallOutput1 into output, we need to ensure we also include current input[startIndex] as the first element of that row
        int output[][] = new int[smallOutput1.length + smallOutput2.length][];
        int index = 0;
        for (int i = 0; i < smallOutput1.length; i++) {
            output[index++] = smallOutput1[i];
        }

        for (int i = 0; i < smallOutput2.length; i++) {
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = input[startIndex];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j+1] = smallOutput2[i][j];
            }
            index++;
        }
        return output;
    }

    private static int[][] subsetsSumKHelper1(int input[], int k, int startIndex) {

        //Base case - If startIndex == input.length
        //We can have two cases in the base condition
        //1. If k==0 - This means the desired sum has been achieved by including the last element of the input array
        //2. If k!=0 - Desired sum has not been achieved even when last element is included
        if (startIndex == input.length) {
            int arr[][];
            if (k == 0) {
                arr = new int[1][0];
            } else {
                arr = new int[0][0];
            }
            return arr;
        }

        //Considering recursive hypothesis where we have the subsets of two cases
        //1. Subsets containing current input[startIndex] element - smallOutput1
        //2. Subsets not containing current input[startIndex] element - smallOutput2
        int smallOutput1[][] = subsetsSumKHelper(input, k - input[startIndex], startIndex + 1);
        int smallOutput2[][] = subsetsSumKHelper(input, k, startIndex + 1);

        //Now, we simply need to combine smallOutput1 and smallOutput2 and return to the calling function
        //When copying smallOutput1 into output, we need to ensure we also include current input[startIndex] as the first element of that row
        int output[][] = new int[smallOutput1.length + smallOutput2.length][];
        for (int i = 0; i < smallOutput2.length; i++) {
            output[i] = new int[smallOutput2[i].length];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[i][j] = smallOutput2[i][j];
            }
        }

        for (int i = 0; i < smallOutput1.length; i++) {
            output[i + smallOutput2.length] = new int[smallOutput1[i].length + 1];
            output[i + smallOutput2.length][0] = input[startIndex];
            for (int j = 1; j < output[i + smallOutput2.length].length; j++) {
                output[i + smallOutput2.length][j] = smallOutput1[i][j - 1];
            }
        }

        return output;
    }


}
