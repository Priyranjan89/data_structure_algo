package com.my.datastrcture.prectice.heap;

import java.util.ArrayList;
/*Certainly! Here's a list of LeetCode problems that involve heap data structures, along with their problem numbers:

Problem 23: Merge k Sorted Lists
Problem 215: Kth Largest Element in an Array
Problem 347: Top K Frequent Elements
Problem 378: Kth Smallest Element in a Sorted Matrix
Problem 373: Find K Pairs with Smallest Sums
Problem 295: Find Median from Data Stream
Problem 692: Top K Frequent Words
Problem 973: K Closest Points to Origin
Problem 1167: Minimum Cost to Connect Sticks
Problem 502: IPO
Problem 218: The Skyline Problem
Problem 373: Find K Pairs with Smallest Sums
Problem 632: Smallest Range Covering Elements from K Lists
Problem 378: Kth Smallest Element in a Sorted Matrix
Problem 373: Find K Pairs with Smallest Sums
Problem 692: Top K Frequent Words
Problem 973: K Closest Points to Origin
Problem 1167: Minimum Cost to Connect Sticks
Problem 502: IPO
Problem 218: The Skyline Problem*/
public class HeapTest {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<Integer>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);
        heap.printHeap();
        /*System.out.println(heap.remove());
        heap.printHeap();*/

        ArrayList list = heap.heapSort();
        System.out.println(list);
    }
}
