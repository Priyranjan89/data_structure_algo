package com.my.datastrcture.recursion.prectice;

public class LastIndexOfX {
    public static void main(String[] args) {
        int arr[] = {9, 8, 10, 8, 23, 8, 6, 0, 70};
        int k = 8;
        System.out.println(lastIndex(arr, k, 0));
    }

    public static int lastIndex(int arr[], int k, int index){
        if (index == arr.length){
            return -1;
        }

        int ans = lastIndex(arr, k, index+1);

        if (k == arr[index] && ans == -1){
            ans = index;
        }
        return ans;
    }
}
