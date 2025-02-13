package com.my.datastrcture.prectice.heap;

import java.util.*;

class Info {
    int data, rIndex, cIndex;

    Info(int x, int y, int z) {
        this.data = x;
        this.rIndex = y;
        this.cIndex = z;
    }
}

// Custom comparator for min-heap
class Compare implements Comparator<Info> {
    public int compare(Info a, Info b) {
        return Integer.compare(a.data, b.data);
    }
}
public class MergeKSortedArray {
    // Function to merge k sorted arrays.
    public static List<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());
        List<Integer> ans = new ArrayList<>();

        int totalRows = arr.length;
        int totalColumns = arr[0].length;

        // Push the first element of each row into the heap
        for (int row = 0; row < totalRows; row++) {
            int element = arr[row][0];
            pq.add(new Info(element, row, 0));
        }

        // Main logic
        while (!pq.isEmpty()) {
            Info front = pq.poll();

            int frontRIndex = front.rIndex;
            int frontCIndex = front.cIndex;
            ans.add(front.data);

            // If more elements are present in the same row, push the next element
            if (frontCIndex + 1 < totalColumns) {
                pq.add(new Info(arr[frontRIndex][frontCIndex + 1], frontRIndex, frontCIndex+ 1));
            }
        }
        return ans;
    }

    // Helper function to print the array
    public static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 10},
                {9, 11, 13},
                {12, 13, 15}
        };

        List<Integer> output = mergeKArrays(matrix, 3);
        printArray(output);
    }
}
