package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(3, 5, -2, -4));
        int n1 = arr1.size();
        System.out.println(maximumProduct(arr1, n1)); // Output: 120

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 4, 3, 5, 6));
        int n2 = arr2.size();
        System.out.println(maximumProduct(arr2, n2)); // Output: 720

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(6, 0, 2, -4));
        int n3 = arr3.size();
        System.out.println(maximumProduct(arr3, n3)); // Output: 6

        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(-1, -3, -4));
        int n4 = arr4.size();
        System.out.println(maximumProduct(arr4, n4)); // Output: 12
    }

    public static int maximumProduct(ArrayList<Integer> arr, int n) {
        if (n == 0) {
            return 0;
        }

        int maxProduct = arr.get(0);
        int minProduct = arr.get(0);
        int maxResult = arr.get(0);

        for (int i = 1; i < n; i++) {
            int tempMax = Math.max(arr.get(i), Math.max(maxProduct * arr.get(i), minProduct * arr.get(i)));
            int tempMin = Math.min(arr.get(i), Math.min(maxProduct * arr.get(i), minProduct * arr.get(i)));

            maxProduct = tempMax;
            minProduct = tempMin;

            maxResult = Math.max(maxResult, maxProduct);
        }

        return maxResult;
    }
}
