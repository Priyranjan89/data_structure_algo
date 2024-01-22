package com.my.datastrcture.codingninja.arrays;

import java.util.List;

/*Problem statement
You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].

Now, in the given array/list, 'M' numbers are present twice and one number is present only once.

You need to find and return that number which is unique in the array/list.

 Note:
Unique element is always present in the array/list according to the given condition.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1 sec
Sample Input 1:
1
7
2 3 1 6 3 6 2
Sample Output 1:
1
Explanation: The array is [2, 3, 1, 6, 3, 6, 2]. Here, the numbers 2, 3, and 6 are present twice, and the number 1 is present only once. So, the unique number in this array is 1.
Sample Input 2:
2
5
2 4 7 2 7
9
1 3 1 3 6 6 7 10 7
Sample Output 2:
4
Explanation: In the first test case, the array is [2, 4, 7, 2, 7]. Here, the numbers 2 and 7 are present twice, and the number 4 is present only once. So, the unique number in this array is 4.

10
Explanation: In the second test case, the array is [1, 3, 1, 3, 6, 6, 7, 10, 7]. Here, the numbers 1, 3, 6, and 7 are present twice, and the number 10 is present only once. So, the unique number in this array is 10.*/
public class FindUniqueElementInArray {
    public static void main(String[] args) {
        //int arr[] = {2, 3, 1, 6, 3, 6, 2};
        int arr[] = {1,3,1,3,6,6,7,10,7};
        //System.out.println("Unique Element in Array : "+findUnique(arr));
        System.out.println("Unique Element in Array : "+lonelyinteger(arr));
        /*System.out.println("Unique Element in Array : "+findFirstUnique(arr));*/
    }

    public static int findUnique(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int j;
            for (j = 0; j < arr.length; j++){
                if (i != j && arr[i] == arr[j]){
                    break;
                }
            }
            if (j == arr.length){
                return arr[i];
            }
        }
        return -1;
    }

    public static int findFirstUnique(int[] arr) {
        // Check for invalid input
        if (arr == null || arr.length == 0) {
            System.out.println("Invalid input: Array is empty");
            return -1;
        }

        // Count occurrences of each element in the array
        int[] elementCount = new int[1001]; // Assuming element values are in the range [0, 1000]

        for (int num : arr) {
            elementCount[num]++;
        }

        // Find the first unique element
        for (int num : arr) {
            if (elementCount[num] == 1) {
                return num;
            }
        }

        // If no unique element is found, return a sentinel value (e.g., -1)
        return -1;
    }

    public static int lonelyinteger(int a[]) {
        int uniqueValue = 0;

        for (int i = 0; i < a.length; i++) {
            uniqueValue = uniqueValue ^ a[i];
        }
        return uniqueValue;
    }
}
