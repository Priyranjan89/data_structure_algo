package com.my.datastrcture.prectice.priorityqueue;

public class InplaceHeapSortDecreaseOrder {
    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 2, 8, 9, 6, 1};
        inplaceHeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void inplaceHeapSort(int arr[]) {
        int n = arr.length;
        //build the heap
        for (int i = (n/2)-1; i >=0; i--){
            downHeapify(arr, i, n);
        }
        //Remove elements from starting one by one, and put them at respective last position
        for (int j = n-1; j >=0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0 , j);
        }
    }

    private static void downHeapify(int arr[], int i, int n) {
        int parentIndex = i;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        while (leftChild < n){
            int minIndex = parentIndex;

            if (arr[leftChild] < arr[minIndex]){
                minIndex = leftChild;
            }
            if (rightChild < n && arr[rightChild] < arr[minIndex]){
                minIndex = rightChild;
            }
            if (minIndex == parentIndex){
                return;
            }
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
            rightChild = 2 * parentIndex + 2;
        }
    }


    /*public static void inplaceHeapSort(int arr[]) {

        //Build the Heap
        int n = arr.length;
        for (int i = (n/2)-1; i >= 0; i--){
            downHeapify(arr, i, n);
        }
        //Remove elements from starting one by one, and put them at respective last position
        for (int j = n-1; j>=0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0 , j);
        }

    }

    private static void downHeapify(int arr[], int i, int n) {
        int parentIndex = i;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        while (leftChild < n) {
            int minIndex = parentIndex;
            if (arr[leftChild] < arr[minIndex]) {
                minIndex = leftChild;
            }

            if (rightChild < n && arr[rightChild] < arr[minIndex]) {
                minIndex = rightChild;
            }
            if (minIndex == parentIndex) {
                return;
            }
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
            rightChild = 2 * parentIndex + 2;

        }
    }*/
}
