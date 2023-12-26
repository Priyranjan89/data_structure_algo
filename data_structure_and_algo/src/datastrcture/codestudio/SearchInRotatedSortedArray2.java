package datastrcture.codestudio;

import java.util.ArrayList;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        //int arr[] = {11 3 4 5 6 7 8 9};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);

        int n = arr.size();
        int k = 7;

        System.out.println("Index of "+k+" is : "+search(arr, n, k));
    }

    public static int binarySearch(ArrayList<Integer> arr, int si, int ei, int k) {
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr.get(mid) == k) {
                return mid;
            }

            if (arr.get(mid) > k) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return -1;

    }

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int start = 0, end = n - 1;

        int pivot = 0, index;
        // Finding the pivot element.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) < arr.get(0)) {
                pivot = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // Searching for element in two half using binary search.
        if (pivot == 0 || (k <= arr.get(n - 1) && k >= arr.get(pivot))) {
            index = binarySearch(arr, pivot, n - 1, k);
        } else {
            index = binarySearch(arr, 0, pivot - 1, k);
        }

        return index;

    }
}
