package com.my.datastrcture.leetcode.medium;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
      /*  int nums[] = {4,5,6,7,0,1,2};
        int target = 3;*/

        int nums[] = {3,1};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
       int pivotIndex = getPivotIndex(nums);
       int end = nums.length-1;
       if (target >= nums[0] && target <= nums[pivotIndex]){
           return binarySearch(nums, 0, pivotIndex, target);
       } else {
           return binarySearch(nums, pivotIndex+1, end, target);
       }
    }

    private static int getPivotIndex(int arr[]){
        int s = 0;
        int n = arr.length;
        int e = n-1;
        int mid = s+(e-s)/2;

        while(s <= e) {
            if(s == e) {
                //single element k case me
                //humne usse hi pivot maaanlia hai
                return s;
            }
            if(mid+1 < n && arr[mid] > arr[mid+1]) {
                return mid;
            }
            //kab left or kab right
            if(arr[s] > arr[mid] ) {
                e = mid-1;
            }
            else {
                //right
                s = mid+1;
            }
            mid = s+(e-s)/2;
        }
        return -1;
    }

    private static int binarySearch(int nums[], int start, int end, int target){
        int mid = start + (end - start) / 2;

        while (start <= end){
            if (nums[mid] == target){
                return mid;
            } else if (target > nums[mid] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }
}
