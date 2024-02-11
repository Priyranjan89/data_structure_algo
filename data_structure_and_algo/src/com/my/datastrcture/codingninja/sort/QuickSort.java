package com.my.datastrcture.codingninja.sort;

public class QuickSort {
    public static void main(String[] args) {
        int input[] = {4,3,8,4,6,5};
        //int input[] = {7,2,6,8,5,4,3,9};
        quickSort(input, 0, input.length-1);
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void quickSort(int[] input,int startIndex, int endIndex) {

        if (startIndex >= endIndex){
            return;
        }
        int p = partition(input, startIndex, endIndex);

        quickSort(input, startIndex, p-1);
        quickSort(input, p+1, endIndex);
    }

    public static int partition(int input[], int start, int end){

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
            if (input[i] <= pivot){
                i++;
            } else if (input[j] > pivot) {
                j--;
            } else {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        /*while (i < pivotIndex && j > pivotIndex){

            while (input[i] <= pivot){
                i++;
            }
            while (input[j] > pivot){
                j--;
            }

            if (i < pivotIndex && j > pivotIndex){
                swap(input, i, j);
                i++;
                j--;
            }
        }*/

        return pivotIndex;
    }

    public static void swap(int input[], int start, int end){
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;

    }
}
