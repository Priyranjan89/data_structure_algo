package com.my.datastrcture.codingninja.timecomplexxity;

public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rotate(arr, d);
    }
    public static void rotate(int[] arr, int d) {
        int len = arr.length;

        if (d > len){
            d = d%len;
        }
        reverseArray(arr, 0, len-1);
        reverseArray(arr, 0, len-d-1);
        reverseArray(arr, len-d, len-1);
        for (int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void reverseArray(int arr[], int l, int r) {
        /*l = Math.abs(l);
        r = Math.abs(r);*/
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
