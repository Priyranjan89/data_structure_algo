package com.my.datastrcture.codingninja.arrays;

public class SmallestElement {
    public static void main(String[] args) {
        int arr[] = {7,3,8,3,9,6,2,10};
        int ans = minimum_element(arr);
        System.out.println(ans);
    }

    public static int minimum_element(int[] arr){
        int ans = Integer.MAX_VALUE;
        for(int i : arr){
            if (ans > i){
                ans = i;
            }
        }
        return ans;
    }
}
