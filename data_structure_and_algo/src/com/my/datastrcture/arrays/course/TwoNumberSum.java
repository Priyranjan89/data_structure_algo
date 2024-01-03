package com.my.datastrcture.arrays.course;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] nums, int target){

        for (int i =0; i<nums.length; i++){
            for (int j = i+1; j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    int result[] = {i, j};
                    return result;
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int num[] = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int result[] = twoNumberSum(num, targetSum);
        System.out.print("[ ");
        for (int i =0; i< result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.print("]");
    }
}
