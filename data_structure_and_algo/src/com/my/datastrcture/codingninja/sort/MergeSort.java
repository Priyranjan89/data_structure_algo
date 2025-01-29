package com.my.datastrcture.codingninja.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {2, 13, 4, 4, 1, 3, 6, 28};
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

        int k = 0;
        for (int i = arr.length/2; i < arr.length; i++){
            //c[i-arr.length/2] = arr[i];
            c[k++] = arr[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge( b, c, arr);
    }



    private static int[] merge(int s1[], int s2[], int arr[]) {
        int i = 0, j = 0, k = 0;

        while (i < s1.length && j < s2.length){
            if (s1[i] < s2[j]){
                arr[k++] = s1[i++];
            } else {
                arr[k++] = s2[j++];
            }
        }

        while (i < s1.length){
            arr[k++] = s1[i++];
        }

        while (j < s2.length){
            arr[k++] = s2[j++];
        }

        return arr;
    }
}
