package com.my.datastrcture.codingninja.timecomplexxity;

import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = 12;
        System.out.println(tripletSum(arr, n));
    }
    public static int tripletSum(int[] arr, int num) {
        int n = arr.length;
        Arrays.sort(arr);
         int ans = 0;

         for (int  i = 0; i < n-2; i++){
             int low = i+1, high = n-1;

             while (low < high){
                 int currentSum = arr[i] + arr[low] + arr[high];

                 if (currentSum == num){
                     ans++;
                     int tempHigh = high -1;
                     while (tempHigh > low){
                         if (arr[high] == arr[tempHigh]){
                             ans++;
                             tempHigh--;
                         } else {
                             break;
                         }
                     }
                     low++;

                 } else if (currentSum > num) {
                     high--;
                 } else {
                     low++;
                 }
             }
         }
         return ans;
    }
}
