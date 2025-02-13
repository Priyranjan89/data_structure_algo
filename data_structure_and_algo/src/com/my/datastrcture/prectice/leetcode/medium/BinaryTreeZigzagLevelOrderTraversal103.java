package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103 bt = new BinaryTreeZigzagLevelOrderTraversal103();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        List<List<Integer>> result = bt.zigzagLevelOrder(root);
        for (List<Integer> lists : result) {
            for (int num : lists) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }
}
