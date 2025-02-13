package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal102 bt = new BinaryTreeLevelOrderTraversal102();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2 , 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        List<List<Integer>> result = bt.levelOrder2(root);
        for (List<Integer> lists : result){
            for (int num : lists){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<TreeNode> pendingNode = new LinkedList<>();
        pendingNode.offer(root);
        pendingNode.offer(null);

        List<Integer> level = new ArrayList<>();

        while (!pendingNode.isEmpty()){
            TreeNode front = pendingNode.poll();

            if (front == null){
                result.add(level);
                if (!pendingNode.isEmpty()){
                    pendingNode.offer(null);
                    level = new ArrayList<>();
                }
            } else {
               level.add(front.val);
               if (front.left != null){
                   pendingNode.offer(front.left);
               }
               if (front.right != null){
                   pendingNode.offer(front.right);
               }
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
