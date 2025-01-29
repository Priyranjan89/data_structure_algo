package com.my.datastrcture.binary.search;

public class BinarySearchTest {
    public static void main(String[] args) {
        int even[] = {2,4,6,8,12,18};
        int odd[] = {3, 8, 11, 14, 16};

        int evenIndex = binarySearch(even, 6, 6);

        System.out.println(" Index of 6 is " + evenIndex);

        int oddIndex = binarySearch(odd, 5, 14);

        System.out.println(" Index of 14 is " + oddIndex);


    }

    public static int binarySearch(int arr[], int size, int target) {

        int start = 0;
        int end = size-1;
        int mid = start +(end-start)/2;

        while (start <= end){
            //Comparing middile index value with target
            if (arr[mid] == target){
                return mid;
            }

            //If target value is greater than middle index value than go to right side in array
            if (target > arr[mid]){
                start = mid+1;
            }else { //If target value is less than middle index value than go to array lift side in array
                end = mid -1;
            }
            //now start or end value has been changed than again we need to calculate middle value
            mid = start +(end-start)/2;
        }

        return -1;

    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end -start) / 2;

        while (start <= end){
            if (nums[mid] == target){
                return mid;

            } else if (target > nums[mid]){
                start  = mid + 1;

            } else {
                end = mid - 1;
            }
            mid = start + (end -start) / 2;
        }

        return -1;
    }
}
