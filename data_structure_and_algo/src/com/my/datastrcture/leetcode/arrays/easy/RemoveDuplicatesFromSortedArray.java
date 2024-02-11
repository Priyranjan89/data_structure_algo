package com.my.datastrcture.leetcode.arrays.easy;

public class RemoveDuplicatesFromSortedArray {
    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num[] = {0,0,1,1,1,2,2,3,3,4};
        printArray(num);
        System.out.println(removeDuplicates(num));
        printArray(num);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i =1; i<nums.length;i++){
            if (nums[i-1] != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
