package com.my.datastrcture.interview;
/*
* Problem Statement
Write a function findSmallerNumGapBetter(List<Integer> nums) that takes a list of integers nums. For each element in nums, find the number of elements to the right until encountering the next smaller element. If there is no smaller element to the right, record 0.

For example:

java
Copy code
Input:  [73, 74, 75, 71, 69, 72, 76, 73]
Output: [3, 2, 1, 1, 0, 2, 1, 0]
Explanation:

For 73 (at index 0), the next smaller element is 71 (3 positions away).
For 74 (at index 1), the next smaller element is 71 (2 positions away), and so on.
Solution Explanation
We solve this in
𝑂(𝑛)
O(n) time complexity by using a stack:

Initialize an answer list ans with zeros (for elements without a smaller element) and an empty stack.
Traverse nums from right to left:
For each element nums[i], pop elements from the stack that are not smaller than nums[i] since they can't be the "next smaller" element.
If the stack is not empty after popping, the top element's index is the nearest smaller element's position. Calculate the distance and store it in ans[i].
Push the current index i onto the stack.
Return ans, which now has the distances to the next smaller elements or 0 where none exists.
This solution is efficient as each element is processed at most twice (once pushed and once popped), ensuring
𝑂(𝑛)
O(n) time complexity.
* */
import java.util.*;

public class FindSmallerNumGap {
    public static void main(String[] args) {
        // Write your code here
        // inp [73, 74, 75, 71, 69, 72, 76, 73]
        // out [3, 2, 1, 1, 0, 0, 1, 0]
        List<Integer> nums = Arrays.asList(73, 74, 75, 71, 69, 72, 76, 73);
        List<Integer> output = findSmallerNumGapBetter(nums);
        output.stream().forEach(num -> System.out.print(num +" "));
    }

    public static List<Integer> findSmallerNumGap(List<Integer> nums) {
        // Write your code here
        // inp [73, 74, 75, 71, 69, 72, 76, 73]
        // out [3, 2, 1, 1, 0, 0, 1, 0]
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int gap = 0;

            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(i)) {
                    gap = j - i; // Calculate the distance to the smaller number
                    break;
                }
            }

            ans.add(gap); // Add the result for the current element
        }
        return ans;

    }

    public static List<Integer> findSmallerNumGapBetter(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>(Collections.nCopies(nums.size(), 0));
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums.get(i) <= nums.get(stack.peek())) {
                stack.pop();
            }

            int diff = stack.isEmpty() ? 0 : stack.peek() - i;
            ans.set(i, diff);
            stack.push(i);
        }

        return ans;
    }
}
