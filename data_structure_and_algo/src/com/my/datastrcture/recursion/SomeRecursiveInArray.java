package com.my.datastrcture.recursion;

import java.util.Arrays;

public class SomeRecursiveInArray {

    public static boolean someRecursive(int[] arr, OddFunction odd){
        if (arr.length == 0){
            return false;
        } else if (odd.run(arr[0]) == false){
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};;

        System.out.println(someRecursive(arr, new OddFunction()));
    }
}
