package com.my.datastrcture.prectice.priorityqueue;

public class InplaceHeapSortIncreaseOrder {
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
        //Sort in decreasing order
        for (int j = n-1; j >=0; j--){
            // Swap the largest element (root of the heap) with the last element in the heap
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            // Restore the heap property after reducing the heap size by 1
            downHeapify(arr, 0 , j);
        }
    }

    private static void downHeapify(int arr[], int i, int n) {
        int parentIndex = i;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        while (leftChild < n){
            int minIndex = parentIndex;

            if (arr[leftChild] > arr[minIndex]){
                minIndex = leftChild;
            }
            if (rightChild < n && arr[rightChild] > arr[minIndex]){
                minIndex = rightChild;
            }
            if (minIndex == parentIndex){
                return;
            }

            // Swap the parent with the largest of the children
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
            rightChild = 2 * parentIndex + 2;
        }
    }

}
