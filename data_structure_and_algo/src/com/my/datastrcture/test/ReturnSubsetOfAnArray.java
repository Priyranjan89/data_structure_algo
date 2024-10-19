package com.my.datastrcture.test;

public class ReturnSubsetOfAnArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        //int arr[] = {15, 20, 12};

        int output[][] = subsets(arr);
        for(int i = 0; i < output.length; i++) {
            System.out.print("[");
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static int[][] subsets(int input[]) {
        return subsetsHelper(input, 0);
    }
    public static int[][] subsetsHelper(int input[], int si) {
        if (si == input.length){
            int ans[][] = new int[1][0];
            return ans;
        }
        int smallAns[][] = subsetsHelper(input, si+1);
        int ans[][] = new int[2 * smallAns.length][0];
        int k = 0;

        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++){
                ans[k][j] = smallAns[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length+1];
            ans[k][0] = input[si];
            for (int j = 0; j < smallAns[i].length; j++){
                ans[k][j+1] = smallAns[i][j];
            }
            k++;
        }

        return ans;
    }
    /*public static int[][] subsets(int input[], int si) {

        if (si == input.length){
            int ans[][] = new int[1][0];
            return ans;
        }
        int smallAns[][] = subsets(input, si+1);
        int ans[][] = new int[2*smallAns.length][0];
        int k = 0;

        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++){
                ans[k][j] = smallAns[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallAns.length; i++){
            ans[k] = new int[smallAns[i].length+1];
            ans[k][0] = input[si];
            for (int j = 0; j < smallAns[i].length; j++){
                ans[k][j+1] = smallAns[i][j];
            }
            k++;
        }

        return ans;
    }
*/
}
