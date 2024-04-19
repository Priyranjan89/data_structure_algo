package com.my.datastrcture.codingninja.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {2, 13, 4, 1, 3, 6, 28};
        int l =0;
        int r = arr.length-1;
        mergeSort(arr);
        for (int i : arr){
            System.out.print(i+" ");
        }
    }


    public static void mergeSort(int[] arr){
        if (arr.length <= 1){
            return;
        }

        int b[] = new int[arr.length/2];
        int c[] = new int[arr.length - b.length];

        for (int i = 0; i < arr.length/2; i++){
            b[i] = arr[i];
        }

        for (int i = arr.length/2; i < arr.length; i++){
            c[i-arr.length/2] = arr[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge( b, c, arr);
    }



    public static int[] merge(int s1[], int s2[], int d[]) {
        int i = 0, j = 0, k = 0;

        while (i < s1.length && j < s2.length){
            if (s1[i] < s2[j]){
                d[k++] = s1[i++];
            } else {
                d[k++] = s2[j++];
            }
        }

        while (i < s1.length){
            d[k++] = s1[i++];
        }

        while (j < s2.length){
            d[k++] = s2[j++];
        }

        return d;
    }
}
