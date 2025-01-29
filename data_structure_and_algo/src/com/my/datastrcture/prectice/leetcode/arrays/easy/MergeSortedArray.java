/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.*/

package com.my.datastrcture.prectice.leetcode.arrays.easy;

public class MergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        printArray(nums1);
        int nums2[] = {2,5,6};
        int n = 3;
        printArray(nums2);
        merge(nums1, m, nums2, n);
        printArray(nums1);
    }

    /*Intuition
My approach to solving this problem involves merging two sorted arrays while ensuring that the
merged array remains sorted. Instead of merging from the end, I'll merge from the beginning by
placing elements in their correct positions.

Approach
I will initialize three pointers, 'p1', 'p2', and 'pMerge', where 'p1' and 'p2' point to the
last valid elements in nums1 and nums2, respectively. 'pMerge' will point to the last available
 position in nums1. I'll start from the end of both arrays and compare elements at 'p1' and 'p2'.
 I'll place the larger element at 'pMerge' and decrement the corresponding pointers and 'pMerge'.
 I'll continue this process until all elements from nums2 are merged into nums1.

Complexity
Time complexity: O(m + n)
The algorithm iterates through both arrays once, where 'm' is the length
of nums1 and 'n' is the length of nums2.

Space complexity: O(1)
The algorithm uses a constant amount of extra space for variables,
 so the space complexity is constant.*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int positionM = m - 1;
        int positionN = n - 1;
        int positionToMerge = m + n - 1;

        while (positionN >= 0) {

            if (positionM >= 0 && nums1[positionM] > nums2[positionN]) {


                nums1[positionToMerge] = nums1[positionM];

                positionToMerge--;
                positionM--;

            } else {
                nums1[positionToMerge] = nums2[positionN];

                positionToMerge--;
                positionN--;
            }
        }
    }


    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length <= 0){
            return;
        }
        int j = 0;
        for (int i = 0 ; i < nums1.length && j < nums2.length; i++){
            if (nums2[j] <= nums1[i] ){
                for (int k = m; k > i; k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
                m++;

            } else if (i == m){
                nums1[i] = nums2[j];
                j++;
                m++;
            }
        }
    }*/

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
