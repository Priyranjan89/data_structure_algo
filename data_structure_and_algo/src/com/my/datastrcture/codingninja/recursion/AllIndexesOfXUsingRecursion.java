package com.my.datastrcture.codingninja.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllIndexesOfXUsingRecursion {
    public static void main(String[] args) {
        int input[] = {13, 8, 10, 1, 3, 24, 3};
        int x = 13;

        int arr[] = allIndexes(input, x);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static int[] allIndexes(int input[], int x) {

        List<Integer> indexes =  findIndexes(input, x, 0);
        int n = indexes.size();
        int arr[] = new int[n];
        for (int i= 0, j = n-1; i <arr.length; i++, j--){
            arr[i] = indexes.get(j);
        }
        return arr;
    }

    private static List<Integer> findIndexes(int input[], int x, int startIndex) {
        if (startIndex == input.length){
            return new ArrayList<Integer>();
        }
        List<Integer> indexes = findIndexes(input, x, startIndex+1);

        if (input[startIndex] == x){
            indexes.add(startIndex);
        }
        return indexes;
    }
}
