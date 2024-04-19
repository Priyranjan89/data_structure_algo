package com.my.datastrcture.codingninja.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int arr[] = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};

        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr);
        for (int num : ans){
            System.out.print(num+" ");
        }
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        int maxlength = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                int length = 0;
                int temp = arr[i];
                while (map.containsKey(temp)) {
                    length++;
                    map.put(temp, false);
                    temp = temp + 1;
                }
                int starttemp = arr[i];
                temp = arr[i] - 1;
                while (map.containsKey(temp)) {
                    length++;
                    map.put(temp, false);
                    starttemp = temp;
                    temp = temp - 1;
                }

                if (length > maxlength) {
                    maxlength = length;
                    start = starttemp;
                } else if (length == maxlength) {
                    maxlength = length;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == start) {
                            start = start;
                            break;
                        } else if (arr[j] == starttemp) {
                            start = starttemp;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = start; i < start + maxlength; i++) {
            output.add(i);
        }

        ans.add(output.get(0));
        ans.add(output.get(output.size()-1));
        return ans;
    }

}
