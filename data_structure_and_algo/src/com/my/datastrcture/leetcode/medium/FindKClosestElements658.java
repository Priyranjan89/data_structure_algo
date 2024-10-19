package com.my.datastrcture.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 4, x = 3;

        List<Integer> ans = findClosestElements(arr, k, x);
        for (int val : ans){
            System.out.print(val+" ");
        }
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        //return twoPointerMethod(arr, k, x);
        return binarySearchMethod(arr, k, x);
    }

    private static List<Integer> twoPointerMethod(int[] arr, int k, int x){
        int l = 0;
        int h = arr.length-1;
        List<Integer> ans = new ArrayList<>();

        while (h-l >= k){
            if (x - arr[l] > arr[h] - x){
                l++;
            } else {
                h--;
            }
        }
        for (int i = l; i <= h; i++){
            ans.add(arr[i] );
        }

        return ans;
    }
    private static List<Integer> binarySearchMethod(int[] arr, int k, int x){
        int h = lowerBound(arr, x);
        List<Integer> ans = new ArrayList<>();
        int l = h-1;
        while (k-- > 0){
            if (l < 0){
                h++;
            } else if (h >= arr.length) {
                l--;
            } else if (x - arr[l] > arr[h] - x) {
                h++;
            } else {
                l--;
            }
        }
        for (int i = l+1; i < h; i++){
            ans.add(arr[i] );
        }

        return ans;
    }

    private static int lowerBound(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;
        int ans = end;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x){
                ans = mid;
                end = mid-1;
            } else if (x > arr[mid]){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
}
