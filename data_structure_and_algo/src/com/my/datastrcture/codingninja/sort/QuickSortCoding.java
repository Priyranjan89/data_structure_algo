package com.my.datastrcture.codingninja.sort;

public class QuickSortCoding {
    public static void main(String[] args) {
        int input[] = {4,3,8,4,6,5};
        quickSort(input, 0, input.length-1);
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
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
