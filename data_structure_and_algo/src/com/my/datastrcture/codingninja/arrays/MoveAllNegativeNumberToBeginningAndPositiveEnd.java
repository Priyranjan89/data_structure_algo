package com.my.datastrcture.codingninja.arrays;

/*Problem statement
You are given an array 'ARR' consisting of 'N' integers. You need to rearrange the array elements such that all negative numbers appear before all positive numbers.

Note:
The order of elements in the resulting array is not important.
Example:
Let the array be [1, 2, -3, 4, -4, -5]. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-3, -5, -4, 2, 4, 1].
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 5 * 10^4
-10^5 <= ARR[i] <= 10^5

Where  ‘T’ represents the number of test cases and ‘N’ represents the number of elements present in the array.

Time Limit: 1 sec
Sample Input 1:
2
5
1 -4 -2 5 3
2
2 1
Sample Output 1:
Yes
Yes
Explanation for Sample Input 1:
For the first test case we have, array: [1, -4, -2, 5, 3] and N = 5. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-2, -4, 1, 5, 3].

For the second test case we have, array: [2, 1] and N = 2. There are no negative numbers. Hence, we do not require any rearrangement.
Sample Input 2:
3
4
1 -5 -5 3
5
-1 -2 3 4 5
1
-2
Sample Output 2:
Yes
Yes
Yes
Explanation for Sample Input 2:
For the first test case we have, array: [1, -5, -5,  3] and N = 4. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-5, -5, 1, 3].

For the second test case we have, array: [-1, -2, 3, 4, 5] and N = 5. There are already arranged in required way. Hence, we do not require any rearrangement.

For the third test case we have, array: [-2 ] and N = 1. The array is already arranged in required way. Hence, we do not require any rearrangement.*/


public class MoveAllNegativeNumberToBeginningAndPositiveEnd {
    public static void main(String[] args) {
        int arr[] = {1, 2, -3, 4, -4, -5};
        printArray(arr);
        separateNegativeAndPositive(arr);
        printArray(arr);
    }

    public static int[] separateNegativeAndPositive(int a[]) {
        int placeToMoveNegativeNumber = 0;
        int positive = 0;
        while (positive < a.length){
            if (a[positive] < 0){
                swap(a, positive, placeToMoveNegativeNumber);
                placeToMoveNegativeNumber++;
            }
            positive++;
        }
        return a;
    }

    public static void swap(int arr[], int negative, int positive){
        int temp = arr[negative];
        arr[negative] = arr[positive];
        arr[positive] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
