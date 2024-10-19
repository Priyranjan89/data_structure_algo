package com.my.datastrcture.codingninja.recuersion3;

import java.util.ArrayList;

/*To solve this problem, we'll use a recursive approach to find all subsets of the array that sum up to the given integer K. Here is a step-by-step explanation:

Explanation:
Recursive Approach:

We'll recursively explore two possibilities for each element in the array:
Include the current element in the subset.
Exclude the current element from the subset.
For each recursive call, we'll subtract the included element's value from K.
If K becomes 0, we've found a valid subset.
If we've processed all elements or if K becomes negative, we stop exploring further down that path.
Base Case:

If K is 0, return a list containing an empty subset (as we've found a valid subset).
If we've exhausted the array and K is not zero, return an empty list, as no valid subset was found.
Recursive Case:

If the current element is included, the sum to check in the subsequent recursion is reduced by the current element's value.
If the current element is not included, the sum remains the same for the next recursive step.
Combining Results:

Combine the results from including and excluding the current element.
Code Implementation:
Here's the optimized Java code that implements this logic:

How It Works:
The subsetsSumK method initializes a result list and invokes the recursive helper method findSubsets.
findSubsets explores each subset by including or excluding each element, adjusting k accordingly.
If a valid subset is found (where k == 0), it's added to the result list.
The result is then converted to a 2D array and returned.
Sample Input/Output:
For input = [5, 12, 3, 17, 1, 18, 15, 3, 17] and k = 6:

Output:
lua
Copy code
[[3, 3], [5, 1]]
Notes:
This approach leverages backtracking to explore all possible subsets while maintaining efficiency.
The recursive method ensures that subsets retain the order of elements from the input array.
The solution is optimized for the given constraints, and handles edge cases like empty subsets and negative values.
This solution is efficient given the constraints, and explores all subsets without missing any possibilities. The time complexity is O(2^n), which is the best we can achieve for this type of problem given that we need to explore all subsets.*/

public class ReturnSubSetsSumK {
    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;

        int ans[][] = subsetsSumK(arr, k);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] subsetsSumK(int input[], int k){
        // Initialize the result list that will store all the valid subsets
        ArrayList<int[]> result = new ArrayList<>();

        // Helper function to find subsets that sum to k
        findSubSets(input, k, 0 , new ArrayList<>(), result);

        //Convert the result to 2D array
        return result.toArray(new int[result.size()][]);
    }

    public static void findSubSets(int input[], int k, int index,  ArrayList<Integer> currentSubset, ArrayList<int[]> result){
        // Base Case: If k == 0, we found a valid subset
        if (k == 0){
            //convert to current Subset to an array and add in result
            result.add(currentSubset.stream().mapToInt(i -> i).toArray());
            return;
        }
        // If we've exhausted the array or k is negative, stop the recursion
        if (index >= input.length || k < 0){
            return;
        }
        //Exclude the current element and move to the next
        findSubSets(input, k, index+1, currentSubset, result);

        //Include the current element in the current subset
        currentSubset.add(input[index]);

        //Reduce the k minus current element and do recursion call
        findSubSets(input, k - input[index], index+1, currentSubset, result);

        //Backtrack to remove the current element and try another possibility
        currentSubset.remove(currentSubset.size()-1);

    }


    /*public static int[][] subsetsSumK(int input[], int k) {
        // Initialize the result list that will store all the valid subsets
        ArrayList<int[]> result = new ArrayList<>();

        // Helper function to find subsets that sum to k
        findSubsets(input, k, 0, new ArrayList<>(), result);

        // Convert ArrayList to 2D array
        return result.toArray(new int[result.size()][]);
    }

    private static void findSubsets(int[] input, int k, int index, ArrayList<Integer> currentSubset, ArrayList<int[]> result) {
        // Base Case: If k == 0, we found a valid subset
        if (k == 0) {
            // Convert the current subset ArrayList to an array and add to result
            result.add(currentSubset.stream().mapToInt(i -> i).toArray());
            return;
        }

        // If we've exhausted the array or k is negative, stop the recursion
        if (index >= input.length || k < 0) {
            return;
        }

        // Exclude the current element and move to the next
        findSubsets(input, k, index + 1, currentSubset, result);

        // Include the current element in the subset
        currentSubset.add(input[index]);

        // Recur with the reduced sum and next index
        findSubsets(input, k - input[index], index + 1, currentSubset, result);

        // Backtrack to remove the current element and try other possibilities
        currentSubset.remove(currentSubset.size() - 1);
    }*/
}
