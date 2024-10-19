package com.my.datastrcture.leetcode.easy;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] a={1,3,4,5,6,8,9,14};
        System.out.println(search(a,6));
    }

    private static int search(int[] a, int target) {
        return search(a, target, 0, a.length-1);
    }
    private static int search(int[] a, int target, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if (a[mid] == target){
            return mid;

        } else if (target > a[mid]) {
            return search(a, target, mid+1, end);
        } else {
            return search(a, target, start, mid-1);
        }
    }
}
