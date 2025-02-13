package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeNode;

public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {
        SumRootToLeafNumbers129 sol = new SumRootToLeafNumbers129();

        // Creating a sample tree: [1,2,3,null,null,4,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Sum: " + sol.sumNumbers(root1));  // Output: 25

        // Example 2: [4,9,0,5,1]
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);
        System.out.println("Sum: " + sol.sumNumbers(root2));  // Output: 1026

        // Edge Case: [0,1]
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        System.out.println("Sum: " + sol.sumNumbers(root3));  // Output: 1
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int pathSum) {
        if (root == null) return 0;

        pathSum = pathSum * 10 + root.val;

        // If leaf node, return the computed number
        if (root.left == null && root.right == null) {
            return pathSum;
        }

        // Recur for left and right subtrees
        return helper(root.left, pathSum) + helper(root.right, pathSum);
    }
}
