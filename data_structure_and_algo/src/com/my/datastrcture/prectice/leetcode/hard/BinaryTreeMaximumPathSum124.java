package com.my.datastrcture.prectice.leetcode.hard;

import com.my.datastrcture.prectice.leetcode.TreeNode;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum124 solution = new BinaryTreeMaximumPathSum124();

        // Example 1: Tree [1,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root1)); // Output: 6 (2+1+3)

        // Example 2: Tree [-10,9,20,null,null,15,7]
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root2)); // Output: 42 (15+20+7)

        // Example 3: Single-node tree [5]
        TreeNode root3 = new TreeNode(5);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root3)); // Output: 5

        // Example 4: Tree with negative values [-3]
        TreeNode root4 = new TreeNode(-3);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root4)); // Output: -3
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.val;

        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + root.val;
    }
}
