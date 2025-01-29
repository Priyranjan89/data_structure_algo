package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class PairSumToZero {
    public static void main(String[] args) {
        int arr[] = {2, 1, -2, 2, 3};
        int arr1[] = {-2, 2, 6, -2, 2, -6, 3};
        int size = arr.length;
        System.out.println(PairSum(arr, size));
        System.out.println(PairSum(arr1, arr1.length));
    }

    /*public static int PairSum(int[] input, int size) {
        if (size == 0) return 0;

        HashMap<Integer, Integer> elementCount = new HashMap<>();
        int count = 0;

        for (int num : input) {
            int neg = -num;
            if (elementCount.containsKey(neg)) {
                count += elementCount.get(neg);
            }
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }

        return count;
    }*/

    public static int PairSum(int[] input, int size) {
        if (size == 0){
            return 0;
        }
        HashMap<Integer, Integer> elementMap = new HashMap<>();
        int count = 0;

        for (int num : input){
            int neg = -num;
            if (elementMap.containsKey(neg)) {
                count += elementMap.get(neg);
            }
            elementMap.put(num, elementMap.getOrDefault(num, 0)+1);
        }

        return count;
    }
}
