package com.my.datastrcture.codingninja.hashmap;

import java.util.HashMap;

public class PrintIntersection {
    public static void main(String[] args) {
        int arr1[] = {7, 7, 7};
        int arr2[] = {7,7,7,7};
        printIntersection(arr1, arr2);
    }

    public static void printIntersection(int[] arr1,int[] arr2){
        if (arr1.length == 0 || arr2.length == 0)
            return;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i]))
                map.put(arr1[i], map.get(arr1[i]) + 1);
            else
                map.put(arr1[i], 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                if (map.get(arr2[i]) != 0) {

                    System.out.println(arr2[i]);
                    map.put(arr2[i], map.get(arr2[i]) - 1);
                }
            }
        }
    }
}
