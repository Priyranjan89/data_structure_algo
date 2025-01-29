package com.my.datastrcture.leetcode.hard;

import java.util.Map;
import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleInHistogram84 a = new LargestRectangleInHistogram84();
        System.out.println(a.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int  i =1; i < heights.length; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()){
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area = 0;
         int popped = stack.pop();
         if (stack.isEmpty()){
             area = heights[popped] * i;
         } else {
             area = heights[popped] * (i - 1 - stack.peek());
         }

        return Math.max(max, area);
    }
}
