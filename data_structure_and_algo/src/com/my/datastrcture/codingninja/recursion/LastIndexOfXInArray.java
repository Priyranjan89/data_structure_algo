package com.my.datastrcture.codingninja.recursion;

public class LastIndexOfXInArray {
    public static void main(String[] args) {
        int arr[] = {13, 8, 10, 0, 9, 10, 24, 12};
        int x = 8;
        System.out.println(lastIndex(arr, x));
    }

    public static int lastIndex(int input[], int x) {
        //return lastIndex(input, x, 0);
        return lastIndexBetter(input, x, input.length-1);
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
}
