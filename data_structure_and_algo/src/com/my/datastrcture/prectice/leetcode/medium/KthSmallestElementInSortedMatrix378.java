package com.my.datastrcture.prectice.leetcode.medium;
/*Understanding the Problem
We have an n × n sorted matrix, where:

Each row and column is sorted in ascending order.
We need to find the k-th smallest element efficiently.
Code Breakdown
Step 1: Import Required Libraries
java
Copy
Edit
import java.util.PriorityQueue;
PriorityQueue<int[]> is used to implement a min-heap.
The heap helps efficiently extract the smallest element.
Step 2: Define the Method
java
Copy
Edit
public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
n = matrix.length gives the number of rows/columns (since it's n × n).
k is the position of the smallest element we need to find.
Step 3: Initialize Min-Heap
java
Copy
Edit
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
A min-heap is created using a priority queue.
It stores triplets {value, row, col}:
value → element from the matrix.
row → row index.
col → column index.
The smallest element will always be at the top of the heap.
Step 4: Insert First Column Elements into Heap
java
Copy
Edit
for (int i = 0; i < n; i++) {
    pq.offer(new int[]{matrix[i][0], i, 0});
}
The first column of each row (matrix[i][0]) is added to the heap.
This ensures we always have the smallest available elements.
Heap after this step (Example: matrix = [[1,5,9],[10,11,13],[12,13,15]]):
Heap Contents	Explanation
{1,0,0}	1st row, 1st column (matrix[0][0] = 1)
{10,1,0}	2nd row, 1st column (matrix[1][0] = 10)
{12,2,0}	3rd row, 1st column (matrix[2][0] = 12)
Step 5: Extract k-1 Smallest Elements
java
Copy
Edit
int result = 0;
while (k-- > 0) {
    int[] top = pq.poll();
    result = top[0];
    int row = top[1], col = top[2];
The loop runs k times, removing the smallest element (poll()).
top[0] → Stores the extracted element.
top[1] → Stores the row index.
top[2] → Stores the column index.
Step 6: Insert the Next Element in the Same Row
java
Copy
Edit
    if (col + 1 < n) {
        pq.offer(new int[]{matrix[row][col + 1], row, col + 1});
    }
}
If the next element exists in the same row (col + 1 < n), insert it into the heap.
This ensures we always maintain the smallest available elements in the heap.
Step 7: Return k-th Smallest Element
java
Copy
Edit
return result;
The k-th extracted element is returned.
Example Walkthrough
Input:
java
Copy
Edit
matrix = [
    [1, 5, 9],
    [10, 11, 13],
    [12, 13, 15]
]
k = 8
Initial Heap:
Heap Contents	Explanation
{1,0,0}	1st row, 1st column
{10,1,0}	2nd row, 1st column
{12,2,0}	3rd row, 1st column
Step-by-Step Extraction
Step	Heap Before Poll	Extracted	Heap After Poll	New Element Added
1st	{1,10,12}	1	{5,10,12}	{5,0,1}
2nd	{5,10,12}	5	{9,10,12}	{9,0,2}
3rd	{9,10,12}	9	{10,12,11}	{11,1,1}
4th	{10,11,12}	10	{11,12,13}	{13,1,2}
5th	{11,12,13}	11	{12,13,13}	{13,2,1}
6th	{12,13,13}	12	{13,13,15}	{15,2,2}
7th	{13,13,15}	13	{13,15}	-
8th	{13,15}	13 (Output)	{15}	-
Output:
java
Copy
Edit
13
Time & Space Complexity Analysis
Time Complexity
Heap insertion/removal takes O(log n).
We perform this k times → O(k log n).
Space Complexity
We store at most n elements in the heap → O(n).
Why This Works Efficiently
Uses heap to avoid sorting O(n² log n²).
Keeps only necessary elements instead of storing all.
Always extracts the smallest element efficiently.
Alternative Approaches
Approach	Time Complexity	Space Complexity	Notes
Heap (this method)	O(k log n)	O(n)	Efficient
Binary Search	O(n log(max-min))	O(1)	Hard to implement
Flatten + Sort	O(n² log n²)	O(n²)	Inefficient
Final Thoughts
Heap-based method is optimal for interview use.
Binary search approach is even better but more complex.
Sorting the entire matrix is wasteful in both time & space.*/
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Min-heap storing {value, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Push the first element of each row into the heap
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        // Extract min k-1 times
        int result = 0;
        while (k-- > 0) {
            int[] top = pq.poll();
            result = top[0];
            int row = top[1], col = top[2];

            // Push the next element in the same row (if exists)
            if (col + 1 < n) {
                pq.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return result;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = matrix.length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }else{ //equal to k
                    if(matrix[i][j] < pq.peek()){ //if incoming element is less than peek
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }

        return pq.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int [] arr = new int[n*n];
        int idx = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[k - 1];
    }

    public int kthSmallestBest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        // Binary search on the value range in the matrix
        while (low < high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            int count = countLessOrEqual(matrix, mid); // Count elements <= mid

            if (count < k) {
                low = mid + 1; // Increase lower bound since we need more elements
            } else {
                high = mid; // Mid might be the answer, continue searching
            }
        }
        return low; // The kth smallest element
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int n = matrix.length, count = 0;
        int row = n - 1, col = 0; // Start from bottom-left corner

        // Traverse the matrix diagonally
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1; // Count all elements in this column up to this row
                col++; // Move right
            } else {
                row--; // Move up
            }
        }
        return count; // Total count of elements <= target
    }

    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix378 solution = new KthSmallestElementInSortedMatrix378();

        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k1 = 8;
        System.out.println("Test Case 1: " + solution.kthSmallest(matrix1, k1)); // Output: 13

        int[][] matrix2 = {
                {-5}
        };
        int k2 = 1;
        System.out.println("Test Case 2: " + solution.kthSmallest(matrix2, k2)); // Output: -5
    }
}
