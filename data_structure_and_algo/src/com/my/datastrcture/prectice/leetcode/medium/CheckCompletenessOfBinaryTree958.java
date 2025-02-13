package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.*;


public class CheckCompletenessOfBinaryTree958 {
    // Function to check if the binary tree is complete
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            TreeNode front = q.poll();

            if (front == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false; // If we found a null node before, then it's not a complete tree
                }
                q.add(front.left);
                q.add(front.right);
            }
        }
        return true;
    }

    // Function to build a binary tree from an array representation
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode currNode = queue.poll();

            if (i < arr.length && arr[i] != null) {
                currNode.left = new TreeNode(arr[i]);
                queue.add(currNode.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                currNode.right = new TreeNode(arr[i]);
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    // Main method
    public static void main(String[] args) {
        CheckCompletenessOfBinaryTree958 obj = new CheckCompletenessOfBinaryTree958();

        // Test case 1: Complete Binary Tree
        Integer[] tree1 = {1, 2, 3, 4, 5, 6};
        TreeNode root1 = buildTree(tree1);
        System.out.println(obj.isCompleteTree(root1)); // Output: true

        // Test case 2: Not a Complete Binary Tree
        Integer[] tree2 = {1, 2, 3, 4, 5, null, 7};
        TreeNode root2 = buildTree(tree2);
        System.out.println(obj.isCompleteTree(root2)); // Output: false
    }
}
