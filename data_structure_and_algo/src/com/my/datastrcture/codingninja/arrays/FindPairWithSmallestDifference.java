package com.my.datastrcture.codingninja.arrays;

public class FindPairWithSmallestDifference {
    public static void main(String[] args) {
        int []arr1 = {12, 7, 5};
        int []arr2 = {4, 4, 6};
        int n =3;
        int m = 3;
        System.out.println(smallestDifferencePair(arr1, n, arr2, m));

    }

    public static int smallestDifferencePair(int []arr1, int n, int []arr2, int m) {
        int ans =Integer.MAX_VALUE;

        for (int i= 0; i < n; i++){
            for (int j =0; j < m; j++){
                int temp = Math.abs(arr1[i] -arr2[j]);
                if (temp < ans){
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
