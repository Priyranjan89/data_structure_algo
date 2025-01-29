package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class PrintInterSection {
    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 3, 4, 7};
        printIntersection(arr1, arr2);
    }

    public static void printIntersection(int[] arr1,int[] arr2){
        if (arr1.length == 0 || arr2.length == 0){
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr1){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        for (int val : arr2){
            if (map.containsKey(val)){
                if (map.get(val) != 0){
                    System.out.println(val);
                    map.put(val, map.get(val)-1);
                }
            }
        }
    }

}
