package com.my.datastrcture.leetcode.easy;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        printArray(nums);
        moveZeroes(nums);
        printArray(nums);
    }

    public static void moveZeroes(int[] nums) {
        int nonZero = 0;
        for (int zero = 0; zero < nums.length; zero++){
            if (nums[zero] != 0){
                int temp = nums[zero];
                nums[zero] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
        }
    }

    private static void swap(int arr[], int zero, int nonZero){
        int temp = arr[zero];
        arr[zero] = arr[nonZero];
        arr[nonZero] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
