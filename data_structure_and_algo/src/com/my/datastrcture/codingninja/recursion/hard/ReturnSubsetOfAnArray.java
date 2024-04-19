package com.my.datastrcture.codingninja.recursion.hard;

public class ReturnSubsetOfAnArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        //int arr[] = {15, 20, 12};

        int output[][] = subsets(arr);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] subsets(int input[]) {
        return subsets(input, 0);
    }
    public static int[][] subsets(int input[], int si) {

        if (si == input.length){
            int ans[][] = new int[1][0];
            return ans;
        }

        int smallAns[][] = subsets(input, si+1);
        int ans[][] = new int[smallAns.length * 2][];
        int k =0;

        for (int i = 0; i < smallAns.length; i++){
            ans[i] = new int[smallAns[i].length];
            for (int j =0; j < smallAns[i].length; j++){
                ans[i][j] = smallAns[i][j];
            }
            k++;
        }
        for (int i = 0; i < smallAns.length; i++){
            ans[k+i] = new int[smallAns[i].length+1];
            ans[k+i][0] = input[si];
            for (int j =1; j <= smallAns[i].length; j++){
                ans[k+i][j] = smallAns[i][j-1];
            }
        }

        return ans;
    }
}
