package com.my.datastrcture.binary.search;

public class SearchInAnAlmostSortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70};
        //3, 10, 20, 40, 50, 80, 70
        int size = 7;

        int target = 70;

        int ans = applyBinarySearch(arr, size, target);
        //int ans = applyBinarySearch2(arr, size, target);
        System.out.println("Found at Index: " +ans);
    }

    private static int applyBinarySearch(int[] arr, int size, int target) {
        int start = 0;
        int end = size-1;
        int mid = start + (end - start) / 2;

        while (start <= end){
            if (arr[mid] == target){
                return mid;
            }
            if (mid-1 >= 0 && arr[mid-1] == target){
                return mid - 1;
            }
            if (mid+1 < size && arr[mid+1] == target){
                return mid+1;
            }

            if (target > arr[mid]){
                start = mid+2;
            } else {
                end = mid-2;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    private static int applyBinarySearch2(int[] arr, int size, int target) {
        int s = 0;
        int e = size - 1;
        int mid = s + (e - s) / 2;

        while (s <= e)
        {
            // cout << "printing mid:  " << mid << endl;
            // cout << "target " << target << endl;
            // cout << "arr[mid]: " << arr[mid] << endl << endl;
            if (arr[mid] == target)
            {
                return mid;
            }
            if (arr[mid - 1] == target)
            {
                return mid - 1;
            }
            if (arr[mid + 1] == target)
            {
                return mid + 1;
            }

            if (target > arr[mid])
            {
                // right
                s = mid + 2;
            }
            else
            {
                // left
                e = mid - 2;
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }
}
