package com.my.datastrcture.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        int output[] = searchRange(nums, target);
        System.out.println("["+output[0]+","+output[1]+"]");
    }

    public static int[] searchRange(int[] nums, int target) {
        int output [] = new int[2];
        output [0] = firstOccurrence(nums, target);
        output [1] = lastOccurrence(nums, target);

        return output;
    }

    private static int firstOccurrence(int arr[], int target){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end - start)/2;
        int ans = -1;

        while (start <= end){
            if (arr[mid] == target){
                ans = mid;
                end = mid - 1;

            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start+(end -start)/2;
        }
        return ans;
    }

    private static int lastOccurrence(int arr[], int target){
        int start = 0;
        int end = arr.length-1;
        int mid = start+(end -start)/2;
        int ans = -1;

        while (start <= end){
            if (arr[mid] == target){
                ans = mid;
                start = mid + 1;

            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start+(end -start)/2;
        }
        return ans;
    }

}
