package com.my.datastrcture.codingninja.arrays;

public class MaximiseTheSumOfTwoArray {
    public static void main(String[] args) {
        int arr1[] = {1,5,10,15,20,25};
        int arr2[] = {2,4,5,9,15};
        //System.out.println(maximiseSum(arr1,arr2));
        System.out.println(maximumSumPath(arr1,arr2));
    }
    public static long maximumSumPath(int[] input1, int[] input2) {
        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        long maxSum = 0;
        if (input1.length <= 0 && input2.length <= 0 ){
            return maxSum;
        }

        if (input1.length == 1 && input2.length == 1) {
            if (input1[0] != input2[0]) {
                int sum = input1[0];
                return sum;

            } else {

                sum1 += input1[0];
                sum2 += input2[0];
                maxSum += Math.max(sum1, sum2);

                return maxSum;
            }
        }

        while (i < input1.length && j < input2.length) {
            if (input1[i] < input2[j]) {
                sum1 += input1[i];
                i++;

            } else if (input1[i] > input2[j]) {
                sum2 += input2[j];
                j++;
            } else if (input1[i] == input2[j]) {

                sum1 += input1[i];
                sum2 += input2[j];
                maxSum += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i < input1.length) {
            sum1 += input1[i];
            i++;
        }

        while (j < input2.length) {
            sum2 += input2[j];
            j++;
        }

        maxSum += Math.max(sum1, sum2);
        return maxSum;
    }

   /* public static int maximiseSum(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        int maxSum = 0;

        if (arr1.length == 1 && arr2.length == 1) {
            if (arr1[0] != arr2[0]) {
                int sum = arr1[0];
                return sum;

            } else {

                sum1 += arr1[0];
                sum2 += arr2[0];
                maxSum += Math.max(sum1, sum2);

                return maxSum;
            }
        }

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;

            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j++;
            } else if (arr1[i] == arr2[j]) {

                sum1 += arr1[i];
                sum2 += arr2[j];
                maxSum += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            sum1 += arr1[i];
            i++;
        }

        while (j < arr2.length) {
            sum2 += arr2[j];
            j++;
        }

        maxSum += Math.max(sum1, sum2);
        return maxSum;
    }*/
}
