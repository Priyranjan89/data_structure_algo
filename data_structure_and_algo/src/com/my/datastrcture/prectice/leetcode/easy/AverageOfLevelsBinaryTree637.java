package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;
import com.my.datastrcture.prectice.leetcode.medium.BinaryTreeLevelOrderTraversal102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree637 {
    public static void main(String[] args) {
        AverageOfLevelsBinaryTree637 bt = new AverageOfLevelsBinaryTree637();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        List<Double> result = bt.averageOfLevels(root);

        for (double num : result) {
            System.out.println(num + " ");
        }

        TreeNode tree = bt.findSuccessor(root, 6);
        System.out.println(tree.val);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double totalSum = 0.0;

            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                totalSum = totalSum+ currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            totalSum = totalSum / levelSize;
            result.add(totalSum);
        }
        return result;
    }

    public TreeNode findSuccessor(TreeNode root, int key){
        if (root == null){
            return root;
        }
        Queue<TreeNode> pendingNode = new LinkedList<>();
        pendingNode.offer(root);

        while (!pendingNode.isEmpty()){

            TreeNode front = pendingNode.poll();
            if (front.left != null){
                pendingNode.offer(front.left);
            }
            if (front.right != null){
                pendingNode.offer(front.right);
            }
            if (front.val == key){
                break;
            }
        }
        return pendingNode.peek();
    }
}
