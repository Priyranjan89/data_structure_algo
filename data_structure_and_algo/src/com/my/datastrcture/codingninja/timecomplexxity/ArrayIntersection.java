package com.my.datastrcture.codingninja.timecomplexxity;

public class ArrayIntersection {
    public static void main(String[] args) {
        int a[] = {2,6,8,5,4,3};
        int b[] = {2,3,4,7};
        intersection(a, b);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        quickSort(arr1, 0, arr1.length-1);
        quickSort(arr2, 0, arr2.length-1);

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] == arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

    }
    public static void quickSort(int[] input,int startIndex, int endIndex) {
        if (startIndex >= endIndex){
            return;
        }

        int pivot  = partition(input, startIndex, endIndex);
        quickSort(input, startIndex, pivot-1);
        quickSort(input, pivot+1, endIndex);
    }

    private static int partition(int input[], int start, int end){
        int pivot = input[start];
        int count = 0;

        for (int i = start+1; i <= end; i++){
            if (input[i] <= pivot){
                count++;
            }
        }
        int pivotIndex = start + count;
        swap(input, start, pivotIndex);

        int i = start, j = end;

        while (i < j){
            if (pivot >= input[i]){
                i++;
            } else if (pivot < input[j]) {
                j--;
            } else {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    private static void swap(int input[], int start, int end){
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}
