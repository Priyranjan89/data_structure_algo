package com.my.datastrcture.codingninja.recursion;

public class FirstIndex {
    public static void main(String[] args) {
        int arr[] = {9, 8, 10, 13, 3, 24, 13};
        int x = 13;
        System.out.println(firstIndex(arr, x));
    }

    public static int firstIndex(int input[], int x) {
        return firstIndex(input, x, 0);
    }

    public static int firstIndex(int input[], int x, int startIndex) {
        if (startIndex == input.length){
            return -1;
        }

        if (input[startIndex] == x){
            return startIndex;
        }

        return firstIndex(input, x, startIndex+1);
    }
}
