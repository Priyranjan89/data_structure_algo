package com.my.datastrcture.binary.search;

import java.util.ArrayList;
import java.util.Arrays;

public class FindOneElementNumberOfOccurrenceInArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 2, 5, 8));
        int n = 10;
        int k = 2;
        int firstPosition = firstPosition(arr, n, k);
        int lastPosition = LastPosition(arr, n, k);

        int numberOfOccurrence = (lastPosition - firstPosition) + 1;
        System.out.println("Number of "+k+" occurrence : "+numberOfOccurrence);

    }

    private static int LastPosition(ArrayList<Integer> arr, int n, int k) {
        int start = 0;
        int end  = n-1;
        int ans = -1;
        int mid = start+(end -start)/2;

        while (start <= end){

            if (k == arr.get(mid)){
                ans = mid;
                start = mid + 1;

            } else if (k > arr.get(mid)){
                start = mid + 1;

            } else if (k < arr.get(mid)){
                end = mid - 1;
            }

            mid = start+(end -start)/2;
        }

        return ans;
    }

    private static int firstPosition(ArrayList<Integer> arr, int n, int k) {

        int start = 0;
        int end  = n-1;
        int ans = -1;
        int mid = start+(end -start)/2;

        while (start <= end){

            if (k == arr.get(mid)){
                ans = mid;
                end = mid - 1;

            } else if (k > arr.get(mid)){
                start = mid + 1;

            } else {
                end = mid - 1;
            }

            mid = start+(end -start)/2;
        }

        return ans;
    }

}
