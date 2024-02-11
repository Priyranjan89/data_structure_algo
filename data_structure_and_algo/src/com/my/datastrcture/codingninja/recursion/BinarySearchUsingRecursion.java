package com.my.datastrcture.codingninja.recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] a={1,3,4,5,6,8,9,14};
        System.out.println(search(a,6));
    }

    public static int search(int []nums, int target) {
        return binarySearch(nums,0, nums.length-1, target);

    }

    private static int binarySearch(int[] a, int start, int end, int k) {

        if (start > end){
            return -1;
        }
        int mid = start + (end - start)/2;

        if (a[mid] == k){
            return mid;

        } else if (a[mid] < k) {
            return binarySearch(a, mid+1, end, k);

        } else {
            return binarySearch(a, start, mid-1, k);
        }
    }


}
