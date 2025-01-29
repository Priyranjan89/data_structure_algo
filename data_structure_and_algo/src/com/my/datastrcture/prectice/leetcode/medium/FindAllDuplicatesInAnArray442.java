package com.my.datastrcture.prectice.leetcode.medium;

/*Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.*/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray442 {
    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDuplicates(nums);
        System.out.print("[");
        for (int i : result){
            System.out.print(i+" ");
        }
        System.out.print("]");
    }

    public static List<Integer> findDuplicates(int[] nums) {
       /* List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (set.add(nums[i]) == false){
                list.add(nums[i]);
            }
        }
        return list;*/
        int size=nums.length;
        //Create same length of new array
        int[] arr=new int [size];

        for(int i=0;i<size;i++){
            int element=nums[i];
            //counting same array element and store in new array at element as position
            arr[element-1]++;
        }
        ArrayList<Integer> list =new ArrayList<>();
        for(int i=0;i<size;i++){
            if(arr[i]==2){
                list.add(i+1);
            }
        }
        return list;
    }
}
