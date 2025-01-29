package com.my.datastrcture.prectice.binarytree;

import java.util.ArrayList;

public class LongestPathFromLeafToRoot {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        // Base case: if the current node is null, return an empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // Recursive case: get the longest path from the left and right subtrees
        ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);

        // Choose the longer path, and add the current node's data to it
        if (leftPath.size() > rightPath.size()) {
            leftPath.add(root.data);
            return leftPath;
        } else {
            rightPath.add(root.data);
            return rightPath;
        }
    }

    public static void main(String[] args) {
        // Sample tree: [5, 6, 10, 2, 3, -1, -1, -1, -1, -1, 9, -1, -1]
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(3);
        root.left.right.left = new BinaryTreeNode<>(9);

        // Get the longest path from leaf to root
        ArrayList<Integer> longestPath = longestRootToLeafPath(root);

        // Print the path in reverse order (from leaf to root)
        longestPath.forEach(System.out::println);
    }
}
