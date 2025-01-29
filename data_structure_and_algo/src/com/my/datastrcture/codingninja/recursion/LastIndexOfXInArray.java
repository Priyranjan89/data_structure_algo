package com.my.datastrcture.codingninja.recursion;

public class LastIndexOfXInArray {
    public static void main(String[] args) {
        int arr[] = {13, 8, 10, 0, 9, 8, 24, 12};
        int x = 10;
        System.out.println(lastIndex(arr, x));
    }

    public static int lastIndex(int input[], int x) {
        //return lastIndex(input, x, 0);
        //return lastIndexBetter(input, x, input.length-1);
        return lastIndexBest(input, x, 0, -1);
    }

    public static int lastIndex(int input[], int x, int startIndex) {
        if (startIndex == input.length){
            return -1;
        }

        int k = lastIndex(input, x, startIndex+1);

        if (input[startIndex] == x){
            if(k == -1){
                k = startIndex;
            }
           return k;
        }

        return k;
    }

    public static int lastIndexBetter(int input[], int x, int lastIndex) {
        if (lastIndex < 0){
            return -1;
        }
        if (input[lastIndex] == x){
            return lastIndex;
        }
        return lastIndexBetter(input, x, lastIndex-1);

    }


    private static int lastIndexBest(int input[], int x, int startIndex, int ans) {
        if (startIndex == input.length){
            return ans;
        }
        if (input[startIndex] == x){
            ans = startIndex;
        }
        return lastIndexBest(input, x, startIndex+1, ans);

    }
}
