package datastrcture.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
* Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true


Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000*/
public class UniqueNumberOfOccurrences1207 {
    public static void main(String[] args) {
        int arr[] = {-3,0,1,-3,1,1,1,-3,10,0};
        //int arr[] = {1,0,2};
        //int arr[] = {1,2,2,1,1,3};
        boolean isUniqueOccurrences = uniqueOccurrences(arr);

        if (isUniqueOccurrences){
            System.out.println("Array Unique Occurrence : "+isUniqueOccurrences);
        } else {
            System.out.println("Array Unique Occurrence : "+isUniqueOccurrences);
        }
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i : arr){
            hashmap.put(i, hashmap.getOrDefault(i, 0)+1);
        }

        HashSet<Integer> hashSet = new HashSet<>(hashmap.values());

        return hashSet.size() == hashmap.size();
    }
}
