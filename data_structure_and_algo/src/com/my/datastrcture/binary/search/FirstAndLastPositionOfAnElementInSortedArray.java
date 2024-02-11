package com.my.datastrcture.binary.search;
/*Problem Statement

Sample Input 1:
8 2
0 0 1 1 2 2 2 2


Sample output 1:
4 7


Explanation of Sample output 1:
For this testcase the first occurrence of 2 in at index 4 and last occurrence is at index 7.


Sample Input 2:
4 2
1 3 3 5


Sample output 2:
-1 -1


Expected Time Complexity:
Try to do this in O(log(n)).


Constraints:
1 <= n <= 10^5
0 <= k <= 10^9
0 <= arr[i] <= 10^9

Time Limit : 1 second
*/
import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastPositionOfAnElementInSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 2));
        int n = 8;
        int k = 2;
        int ans[] = firstAndLastPosition(arr, n, k);
        System.out.print(" "+ans[0]);
        System.out.print(" "+ans[1]);
    }

    public static int firstOccurrence(ArrayList<Integer> arr, int n, int k){
        int start = 0;
        int end  = n-1;
        int ans = -1;
        int mid = start+(end -start)/2;

        while (start <= end){

            if (arr.get(mid) == k){
                ans = mid;
                end = mid - 1;

            } else if (k > arr.get(mid)){//If key is grater than middle index value, then go to right side
                start = mid+1;

            } else if (k < arr.get(mid)){//If key is less than middle index value, then go to left side
                end = mid - 1;
            }
            mid = start+(end -start)/2;
        }

        return ans;
    }

    public static int lastOccurrence(ArrayList<Integer> arr, int n, int k){
        int start = 0;
        int end  = n-1;
        int ans = -1;
        int mid = start+(end -start)/2;

        while (start <= end){

            if (arr.get(mid) == k){
                ans = mid;
                start = mid + 1;

            } else if (k > arr.get(mid)){//If key is grater than middle index value, then go to right side
                start = mid+1;

            } else if (k < arr.get(mid)){//If key is less than middle index value, then go to left side
                end = mid - 1;
            }
            mid = start+(end -start)/2;
        }

        return ans;
    }


    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int ans[] = new int[2];
        ans[0] = firstOccurrence(arr, n, k);
        ans[1] = lastOccurrence(arr, n, k);
        return ans;
    }
}
