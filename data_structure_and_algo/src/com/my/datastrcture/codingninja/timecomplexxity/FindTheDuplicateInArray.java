package com.my.datastrcture.codingninja.timecomplexxity;

public class FindTheDuplicateInArray {
    public static void main(String[] args) {
        int arr[] = {0,7,2,5,4,7,1,3,6};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++){
            totalSum += arr[i];
        }
        int n = arr.length;
        int cal = ((n - 2) * (n - 1))/2;

        return totalSum - cal;
    }
}
