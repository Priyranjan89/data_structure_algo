package datastrcture.leetcode.medium;

/*An array arr is a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1


Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.*/
public class PeakIndexInMountainArray852 {

    public static void main(String[] args) {
        int arr[] = {0, 10, 15, 12, 7, 5, 2};
        int ans = peakIndexInMountainArray(arr);
        System.out.println("Peak Index In a Mountain Array : " + ans);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;

            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }
}
