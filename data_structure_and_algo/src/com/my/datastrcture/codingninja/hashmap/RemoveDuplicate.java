package com.my.datastrcture.codingninja.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicate {

    public static ArrayList<Integer> removeDup(int arr[]){
        ArrayList<Integer> output = new ArrayList<>();

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                continue;
            }
            output.add(arr[i]);
            map.put(arr[i], true);
        }

        return output;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 2, 3, 1, 6, 2, 5};

        ArrayList<Integer> output = removeDup(arr);

        System.out.print("[");
        for (int num : output){
            System.out.print(num+" ");
        }
        System.out.print("]");
    }
}
