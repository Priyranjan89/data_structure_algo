package com.my.datastrcture.prectice.recursion;

public class ReturnSubsetOfArray {
    public static void main(String[] args) {
        int input[] = {1, 2, 3};
        int ans [][] = subsets(input);
        for (int i = 0; i < ans.length; i++){
            System.out.print("[");
            for (int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static int[][] subsets(int input[]) {
       return subsetsHelper(input, 0);
    }

    private static int[][] subsetsHelper(int input[], int index) {
        if (index == input.length){
            int[][] ans = new int[1][0];
            return ans;
        }
        int[][] smallAns = subsetsHelper(input, index+1);
        int[][] ans = new int[2 * smallAns.length][0];

        int k = 0;
        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length];
            for (int j = 0; j <smallAns[i].length; j++){
                ans[k][j] = smallAns[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length + 1];
            ans[k][0] = input[index];
            for (int j = 0; j <smallAns[i].length; j++){
                ans[k][j+1] = smallAns[i][j];
            }
            k++;
        }

        return ans;
    }
}
