package com.my.datastrcture.codingninja.recuersion3;
/*To solve the problem of printing all subsets of an array A that sum up to K, we can use a recursive backtracking approach. Here's how we can implement this:

Explanation:
Recursive Approach:

We use recursion to explore all possible subsets by deciding whether to include or exclude each element.
For each element in the array, we have two choices: include it in the current subset or exclude it.
If we include it, we subtract its value from K and move to the next element.
If the sum of the current subset equals K, we print the subset.
Base Case:

If K becomes zero, it means we have found a subset that sums up to K, and we should print it.
If we reach the end of the array without achieving the sum, we simply return.
Recursive Case:

Explore both possibilities: including and excluding the current element.
Code Implementation:
Here's the Java code implementing this approach:*/
public class PrintSubSetsSumK {

    public static void main(String[] args) {
        int input[] = {5,12,3,17,1,18,15,3,17};
        int k = 6;
        printSubsetsSumTok(input, k);
    }
    public static void printSubsetsSumTok(int input[], int k) {
        int currentSubset[] = new int[input.length];
        findSubsetHelper(input, k, 0, currentSubset, 0);
    }
    private static void findSubsetHelper(int input[], int k, int index, int currentSubset[], int currentSize){
        if (k == 0){
            for (int i = 0; i < currentSize; i++){
                System.out.print(currentSubset[i]+" ");
            }
            System.out.println();
            return;
        }
        if (index >= input.length || k < 0){
            return;
        }

        //Excluding the current element and move to the next
        findSubsetHelper(input, k, index+1, currentSubset, currentSize);

        //Include the current element in the subset
        currentSubset[currentSize] = input[index];

        //Reduce the k minus current element and increase current index value by 1 and do recursion call
        findSubsetHelper(input, k - input[index], index+1, currentSubset, currentSize+1);

    }
    /*public static void printSubsetsSumTok(int input[], int k) {
        // Array to keep track of the current subset being built
        int[] currentSubset = new int[input.length];

        // Start finding subsets from index 0
        findSubsets(input, k, 0, currentSubset, 0);
    }

    private static void findSubsets(int[] input, int k, int index, int[] currentSubset, int currentSize) {
        // Base Case: If the current sum equals k, print the subset
        if (k == 0) {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(currentSubset[i] + " ");
            }
            System.out.println();
            return;
        }

        // If we've exhausted the array or the remaining sum is negative, stop recursion
        if (index == input.length || k < 0) {
            return;
        }

        // Exclude the current element and move to the next
        findSubsets(input, k, index + 1, currentSubset, currentSize);

        // Include the current element in the subset
        currentSubset[currentSize] = input[index];

        // Recur with the reduced sum and increased current subset size
        findSubsets(input, k - input[index], index + 1, currentSubset, currentSize + 1);
    }
*/
}
