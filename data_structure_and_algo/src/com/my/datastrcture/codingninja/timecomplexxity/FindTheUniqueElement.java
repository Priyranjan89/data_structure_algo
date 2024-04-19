package com.my.datastrcture.codingninja.timecomplexxity;

public class FindTheUniqueElement {

    public static void main(String[] args) {
        //int arr[] = {2,3,1,6,3,6,2};
        int arr[] = {1,3,1,3,6,6,7,10,7};
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        int uniqueValue = 0;
        for (int i = 0; i < arr.length; i++){
            uniqueValue = uniqueValue ^ arr[i];
        }

        return uniqueValue;
    }
}
