package com.my.datastrcture.codingninja.recursion;

public class SumOfArrayUsingRecursion {
    public static void main(String[] args) {
        int arr[] = {9, 8, 9};
        System.out.println(sum(arr));
    }

    public static int sum(int input[]) {
        return sum(input, 0);
    }

    private static int sum(int input[], int n) {
        if (n == input.length){
            return 0;
        }
        if (input.length == 1){
            return input[n];
        }
        return input[n] + sum(input, n+1);
    }
}
