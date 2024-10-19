package com.my.datastrcture.leetcode.medium;

public class SingleElementInASortedArray540 {
    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 4, 4, 5, 7, 7, 8, 8};
        System.out.println("Single Non Duplicate Element: "+singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int s = 0;
        int n = nums.length;
        int e = n-1;
        int mid = s+(e-s)/2;
        while (s <= e){
            //single element
            if (s == e){
                //this is odd element, return it
                return nums[s];
            }

            //mid index pr value
            int currVal = nums[mid];
            //mid-1 index pr value, if exists
            int leftVal = -1;
            if(mid-1 >= 0) {
                leftVal = nums[mid-1];
            }
            //mid+1 index pr value, if exists
            int rightVal = -1;
            if(mid+1 < n) {
                rightVal = nums[mid+1];
            }

            //Duplicate doesn't exist
            if (currVal != leftVal && currVal != rightVal){
                return nums[mid];
            }
            //Duplicate exist in left index
            if (mid-1 >= 0 && currVal == leftVal ){
                int pairStartingIndex = mid-1;
                if(pairStartingIndex % 2 != 0) {
                    //pairStartingIndex is odd
                    //I am standing on right part
                    //move to left
                    e = mid-1;
                }
                else {
                    //pairStartingIndex is even
                    //I am standing on left part
                    //move to right
                    s = mid+1;
                }
            }
            ///Duplicate exist in right index
            else if (mid+1 < n && currVal == rightVal ){
                int pairStartingIndex = mid;
                if(pairStartingIndex % 2 != 0) {
                    //pairStartingIndex is odd
                    //I am standing on right part
                    //move to left
                    e = mid-1;
                }
                else {
                    //pairStartingIndex is even
                    //I am standing on left part
                    //move to right
                    s = mid+1;
                }
            }
            mid = s+(e-s)/2;
        }
        return -1;
    }
}
