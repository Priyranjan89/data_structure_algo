package com.my.datastrcture.codingninja.recursion;

public class CheckNumberRecursively {
    public static void main(String[] args) {
        int arr[] = {6, 3, 8, 4, 7, 2};
        int x = 4;
        System.out.println(checkNumber(arr, x));

    }

    public static boolean checkNumber(int input[], int x) {
       return checkNumber(input, x, 0);
    }

    public static boolean checkNumber(int input[], int x, int n) {
        if (input.length == n || input.length == 0){
            return false;
        }
        if (input[n] == x){
            return true;
        }
        return checkNumber(input, x, n+1);
    }
}
