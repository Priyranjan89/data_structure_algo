package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;

public class MaximuDepthOfBinaryTree104 {
    public static void main(String[] args) {
        MaximuDepthOfBinaryTree104 bt = new MaximuDepthOfBinaryTree104();
        int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};
       /* int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};*/
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println(bt.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
