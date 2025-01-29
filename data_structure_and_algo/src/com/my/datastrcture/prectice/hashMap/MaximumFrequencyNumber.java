package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static void main(String[] args) {
        int arr[] = {2,12,2,11,12,2,1,2,2,11,12,2,6};
        int ans = maxFrequencyNumber(arr);
        System.out.println(ans);
    }
    public static int maxFrequencyNumber(int[] arr){

        HashMap<Integer, Integer > map = new HashMap<>();
        for (int i =0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], (map.get(arr[i]))+1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int maxKey = 0;

        for (int i =0; i < arr.length; i++){
            if (map.get(arr[i]) > max){
                max = map.get(arr[i]);
                maxKey = arr[i];
            }
        }

        return maxKey;
    }
}
